class n3806087 {
	private void processJBossArgs(String currentWorkingDir, String args[]) {
		String programName = this.sysProps.getProperty("program.name", "jboss");
		LongOpt longOpts[] = { new LongOpt("configuration", 1, null, 'c'), new LongOpt("properties", 1, null, 'P'),
				new LongOpt("host", 1, null, 'b') };
		String shortOpts = "-:b:c:D:P:";
		Getopt options = new Getopt(programName, args, shortOpts, longOpts);
		options.setOpterr(false);
		int c;
		while ((c = options.getopt()) != -1) {
			switch (c) {
			case 'b': {
				String arg = options.getOptarg();
				this.sysProps.setProperty(JBossProperties.BIND_ADDRESS, arg);
				break;
			}
			case 'c': {
				String arg = options.getOptarg();
				this.sysProps.setProperty(JBossProperties.SERVER_NAME, arg);
				break;
			}
			case 'D': {
				String arg = options.getOptarg();
				String name = addPropArgToProps(arg, this.sysProps);
				String value = this.sysProps.getProperty(name);
				if (value.equals("")) {
					this.sysProps.setProperty(name, Boolean.TRUE.toString());
				}
				break;
			}
			case 'P': {
				URL url;
				String arg = options.getOptarg();
				Properties props = new Properties();
				try {
					File workingDir = new File(currentWorkingDir);
					url = JBossConfigurationUtility.makeURL(arg, workingDir);
				} catch (Exception e) {
					log.error("Failed to parse argument to --properties option: " + options.getOptarg());
					break;
				}
				InputStream inputStream = null;
				try {
					inputStream = new BufferedInputStream(url.openConnection().getInputStream());
					props.load(inputStream);
				} catch (IOException e) {
					log.error("Could not read properties from file: " + arg, e);
					break;
				} finally {
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							log.error("Failed to close properties file: " + arg, e);
						}
					}
				}
				for (Object nameObj : props.keySet()) {
					String name = (String) nameObj;
					String value = props.getProperty(name);
					String newValue = StringPropertyReplacer.replaceProperties(value, this.sysProps);
					this.sysProps.setProperty(name, newValue);
				}
				break;
			}
			}
		}
	}

}