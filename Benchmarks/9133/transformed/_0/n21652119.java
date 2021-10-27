class n21652119 {
	protected void setupService(MessageContext sC9ZbnN3) throws Exception {
		String BQafGrew = sC9ZbnN3.getStrProp(Constants.MC_REALPATH);
		String G1ytWSXZ = (String) getOption(OPTION_JWS_FILE_EXTENSION);
		if (G1ytWSXZ == null)
			G1ytWSXZ = DEFAULT_JWS_FILE_EXTENSION;
		if ((BQafGrew != null) && (BQafGrew.endsWith(G1ytWSXZ))) {
			String yCKQnsq3 = BQafGrew;
			String qpbIZsXt = sC9ZbnN3.getStrProp(Constants.MC_RELATIVE_PATH);
			File S3bqqU1p = new File(yCKQnsq3);
			if (!S3bqqU1p.exists()) {
				throw new FileNotFoundException(qpbIZsXt);
			}
			if (qpbIZsXt.charAt(0) == '/') {
				qpbIZsXt = qpbIZsXt.substring(1);
			}
			int TiXevaux = qpbIZsXt.lastIndexOf('/');
			String D9nEN54H = null;
			if (TiXevaux > 0) {
				D9nEN54H = qpbIZsXt.substring(0, TiXevaux);
			}
			String Wzbumad9 = qpbIZsXt.substring(TiXevaux + 1);
			String wabQde1K = sC9ZbnN3.getStrProp(Constants.MC_JWS_CLASSDIR);
			if (wabQde1K == null)
				wabQde1K = ".";
			if (D9nEN54H != null) {
				wabQde1K = wabQde1K + File.separator + D9nEN54H;
			}
			File usakiK3Z = new File(wabQde1K);
			if (!usakiK3Z.exists()) {
				usakiK3Z.mkdirs();
			}
			if (log.isDebugEnabled())
				log.debug("jwsFile: " + yCKQnsq3);
			String AdUtYA7A = wabQde1K + File.separator
					+ Wzbumad9.substring(0, Wzbumad9.length() - G1ytWSXZ.length() + 1) + "java";
			String g0AzYyBQ = wabQde1K + File.separator
					+ Wzbumad9.substring(0, Wzbumad9.length() - G1ytWSXZ.length() + 1) + "class";
			if (log.isDebugEnabled()) {
				log.debug("jFile: " + AdUtYA7A);
				log.debug("cFile: " + g0AzYyBQ);
				log.debug("outdir: " + wabQde1K);
			}
			File WJNU0sPp = new File(g0AzYyBQ);
			String JxFZxGpM = null;
			if (JxFZxGpM == null)
				JxFZxGpM = S3bqqU1p.getName();
			if (JxFZxGpM != null && JxFZxGpM.charAt(0) == '/')
				JxFZxGpM = JxFZxGpM.substring(1);
			JxFZxGpM = JxFZxGpM.substring(0, JxFZxGpM.length() - G1ytWSXZ.length());
			JxFZxGpM = JxFZxGpM.replace('/', '.');
			if (log.isDebugEnabled())
				log.debug("ClsName: " + JxFZxGpM);
			if (!WJNU0sPp.exists() || S3bqqU1p.lastModified() > WJNU0sPp.lastModified()) {
				log.debug(Messages.getMessage("compiling00", yCKQnsq3));
				log.debug(Messages.getMessage("copy00", yCKQnsq3, AdUtYA7A));
				FileReader mxL5JISQ = new FileReader(yCKQnsq3);
				FileWriter Uyk7ObCV = new FileWriter(AdUtYA7A);
				char[] pyZaR3VT = new char[4096];
				int ya7hRZK4;
				while ((ya7hRZK4 = mxL5JISQ.read(pyZaR3VT, 0, 4095)) >= 0)
					Uyk7ObCV.write(pyZaR3VT, 0, ya7hRZK4);
				Uyk7ObCV.close();
				mxL5JISQ.close();
				log.debug("javac " + AdUtYA7A);
				Compiler RiXFapgR = CompilerFactory.getCompiler();
				RiXFapgR.setClasspath(ClasspathUtils.getDefaultClasspath(sC9ZbnN3));
				RiXFapgR.setDestination(wabQde1K);
				RiXFapgR.addFile(AdUtYA7A);
				boolean FMSy60kN = RiXFapgR.compile();
				(new File(AdUtYA7A)).delete();
				if (!FMSy60kN) {
					(new File(g0AzYyBQ)).delete();
					Document HHPyv9oO = XMLUtils.newDocument();
					Element Rxx48z0d = HHPyv9oO.createElementNS("", "Errors");
					StringBuffer t2qX4nZJ = new StringBuffer("Error compiling ");
					t2qX4nZJ.append(AdUtYA7A);
					t2qX4nZJ.append(":\n");
					List WC3jtLyK = RiXFapgR.getErrors();
					int QyTughpD = WC3jtLyK.size();
					for (int vPR3GOeO = 0; vPR3GOeO < QyTughpD; vPR3GOeO++) {
						CompilerError Nl0eaowQ = (CompilerError) WC3jtLyK.get(vPR3GOeO);
						if (vPR3GOeO > 0)
							t2qX4nZJ.append("\n");
						t2qX4nZJ.append("Line ");
						t2qX4nZJ.append(Nl0eaowQ.getStartLine());
						t2qX4nZJ.append(", column ");
						t2qX4nZJ.append(Nl0eaowQ.getStartColumn());
						t2qX4nZJ.append(": ");
						t2qX4nZJ.append(Nl0eaowQ.getMessage());
					}
					Rxx48z0d.appendChild(HHPyv9oO.createTextNode(t2qX4nZJ.toString()));
					throw new AxisFault("Server.compileError", Messages.getMessage("badCompile00", AdUtYA7A), null,
							new Element[] { Rxx48z0d });
				}
				ClassUtils.removeClassLoader(JxFZxGpM);
				soapServices.remove(JxFZxGpM);
			}
			ClassLoader XRS2ZR0k = ClassUtils.getClassLoader(JxFZxGpM);
			if (XRS2ZR0k == null) {
				XRS2ZR0k = new JWSClassLoader(JxFZxGpM, sC9ZbnN3.getClassLoader(), g0AzYyBQ);
			}
			sC9ZbnN3.setClassLoader(XRS2ZR0k);
			SOAPService f6Ow7pRM = (SOAPService) soapServices.get(JxFZxGpM);
			if (f6Ow7pRM == null) {
				f6Ow7pRM = new SOAPService(new RPCProvider());
				f6Ow7pRM.setName(JxFZxGpM);
				f6Ow7pRM.setOption(RPCProvider.OPTION_CLASSNAME, JxFZxGpM);
				f6Ow7pRM.setEngine(sC9ZbnN3.getAxisEngine());
				String R3MfegzC = (String) getOption(RPCProvider.OPTION_ALLOWEDMETHODS);
				if (R3MfegzC == null)
					R3MfegzC = "*";
				f6Ow7pRM.setOption(RPCProvider.OPTION_ALLOWEDMETHODS, R3MfegzC);
				String q4iUwZeT = (String) getOption(RPCProvider.OPTION_SCOPE);
				if (q4iUwZeT == null)
					q4iUwZeT = Scope.DEFAULT.getName();
				f6Ow7pRM.setOption(RPCProvider.OPTION_SCOPE, q4iUwZeT);
				f6Ow7pRM.getInitializedServiceDesc(sC9ZbnN3);
				soapServices.put(JxFZxGpM, f6Ow7pRM);
			}
			f6Ow7pRM.setEngine(sC9ZbnN3.getAxisEngine());
			f6Ow7pRM.init();
			sC9ZbnN3.setService(f6Ow7pRM);
		}
		if (log.isDebugEnabled()) {
			log.debug("Exit: JWSHandler::invoke");
		}
	}

}