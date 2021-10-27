class n21652119 {
	protected void setupService(MessageContext msgContext) throws Exception {
		String realpath = msgContext.getStrProp(Constants.MC_REALPATH);
		String extension = (String) getOption(OPTION_JWS_FILE_EXTENSION);
		extension = (extension == null) ? DEFAULT_JWS_FILE_EXTENSION : extension;
		if ((realpath != null) && (realpath.endsWith(extension))) {
			String jwsFile = realpath;
			String rel = msgContext.getStrProp(Constants.MC_RELATIVE_PATH);
			File f2 = new File(jwsFile);
			if (!f2.exists()) {
				throw new FileNotFoundException(rel);
			}
			rel = (rel.charAt(0) == '/') ? rel.substring(1) : rel;
			int lastSlash = rel.lastIndexOf('/');
			String dir = null;
			dir = (lastSlash > 0) ? rel.substring(0, lastSlash) : dir;
			String file = rel.substring(lastSlash + 1);
			String outdir = msgContext.getStrProp(Constants.MC_JWS_CLASSDIR);
			outdir = (outdir == null) ? "." : outdir;
			outdir = (dir != null) ? outdir + File.separator + dir : outdir;
			File outDirectory = new File(outdir);
			if (!outDirectory.exists()) {
				outDirectory.mkdirs();
			}
			if (log.isDebugEnabled())
				log.debug("jwsFile: " + jwsFile);
			String jFile = outdir + File.separator + file.substring(0, file.length() - extension.length() + 1) + "java";
			String cFile = outdir + File.separator + file.substring(0, file.length() - extension.length() + 1)
					+ "class";
			if (log.isDebugEnabled()) {
				log.debug("jFile: " + jFile);
				log.debug("cFile: " + cFile);
				log.debug("outdir: " + outdir);
			}
			File f1 = new File(cFile);
			String clsName = null;
			clsName = (clsName == null) ? f2.getName() : clsName;
			clsName = (clsName != null && clsName.charAt(0) == '/') ? clsName.substring(1) : clsName;
			clsName = clsName.substring(0, clsName.length() - extension.length());
			clsName = clsName.replace('/', '.');
			if (log.isDebugEnabled())
				log.debug("ClsName: " + clsName);
			if (!f1.exists() || f2.lastModified() > f1.lastModified()) {
				log.debug(Messages.getMessage("compiling00", jwsFile));
				log.debug(Messages.getMessage("copy00", jwsFile, jFile));
				FileReader fr = new FileReader(jwsFile);
				FileWriter fw = new FileWriter(jFile);
				char[] buf = new char[4096];
				int rc;
				while ((rc = fr.read(buf, 0, 4095)) >= 0)
					fw.write(buf, 0, rc);
				fw.close();
				fr.close();
				log.debug("javac " + jFile);
				Compiler compiler = CompilerFactory.getCompiler();
				compiler.setClasspath(ClasspathUtils.getDefaultClasspath(msgContext));
				compiler.setDestination(outdir);
				compiler.addFile(jFile);
				boolean result = compiler.compile();
				(new File(jFile)).delete();
				if (!result) {
					(new File(cFile)).delete();
					Document doc = XMLUtils.newDocument();
					Element root = doc.createElementNS("", "Errors");
					StringBuffer message = new StringBuffer("Error compiling ");
					message.append(jFile);
					message.append(":\n");
					List errors = compiler.getErrors();
					int count = errors.size();
					for (int i = 0; i < count; i++) {
						CompilerError error = (CompilerError) errors.get(i);
						if (i > 0)
							message.append("\n");
						message.append("Line ");
						message.append(error.getStartLine());
						message.append(", column ");
						message.append(error.getStartColumn());
						message.append(": ");
						message.append(error.getMessage());
					}
					root.appendChild(doc.createTextNode(message.toString()));
					throw new AxisFault("Server.compileError", Messages.getMessage("badCompile00", jFile), null,
							new Element[] { root });
				}
				ClassUtils.removeClassLoader(clsName);
				soapServices.remove(clsName);
			}
			ClassLoader cl = ClassUtils.getClassLoader(clsName);
			cl = (cl == null) ? new JWSClassLoader(clsName, msgContext.getClassLoader(), cFile) : cl;
			msgContext.setClassLoader(cl);
			SOAPService rpc = (SOAPService) soapServices.get(clsName);
			if (rpc == null) {
				rpc = new SOAPService(new RPCProvider());
				rpc.setName(clsName);
				rpc.setOption(RPCProvider.OPTION_CLASSNAME, clsName);
				rpc.setEngine(msgContext.getAxisEngine());
				String allowed = (String) getOption(RPCProvider.OPTION_ALLOWEDMETHODS);
				allowed = (allowed == null) ? "*" : allowed;
				rpc.setOption(RPCProvider.OPTION_ALLOWEDMETHODS, allowed);
				String scope = (String) getOption(RPCProvider.OPTION_SCOPE);
				scope = (scope == null) ? Scope.DEFAULT.getName() : scope;
				rpc.setOption(RPCProvider.OPTION_SCOPE, scope);
				rpc.getInitializedServiceDesc(msgContext);
				soapServices.put(clsName, rpc);
			}
			rpc.setEngine(msgContext.getAxisEngine());
			rpc.init();
			msgContext.setService(rpc);
		}
		if (log.isDebugEnabled()) {
			log.debug("Exit: JWSHandler::invoke");
		}
	}

}