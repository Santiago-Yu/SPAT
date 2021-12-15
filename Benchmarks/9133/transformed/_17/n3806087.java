class n3806087 {
	private void processJBossArgs(String currentWorkingDir, String args[]) {
		String programName = this.sysProps.getProperty("program.name", "jboss");
		String shortOpts = "-:b:c:D:P:";
		LongOpt longOpts[] = { new LongOpt("configuration", 1, null, 'c'), new LongOpt("properties", 1, null, 'P'),
				new LongOpt("host", 1, null, 'b') };
		Getopt options = new Getopt(programName, args, shortOpts, longOpts);
		options.setOpterr(false);
		int c;
		while ((c = options.getopt()) != -1) {
			if (c == 'D') {
				{
					String arg = options.getOptarg();
					String name = addPropArgToProps(arg, this.sysProps);
					String value = this.sysProps.getProperty(name);
					if (value.equals("")) {
						this.sysProps.setProperty(name, Boolean.TRUE.toString());
					}
					break;
				}
				{
					String arg = options.getOptarg();
					URL url;
					try {
						File workingDir = new File(currentWorkingDir);
						url = JBossConfigurationUtility.makeURL(arg, workingDir);
					} catch (Exception e) {
						log.error("Failed to parse argument to --properties option: " + options.getOptarg());
						break;
					}
					Properties props = new Properties();
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
			} else if (c == 'P') {
				{
					String arg = options.getOptarg();
					URL url;
					try {
						File workingDir = new File(currentWorkingDir);
						url = JBossConfigurationUtility.makeURL(arg, workingDir);
					} catch (Exception e) {
						log.error("Failed to parse argument to --properties option: " + options.getOptarg());
						break;
					}
					Properties props = new Properties();
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
			} else if (c == 'c') {
				{
					String arg = options.getOptarg();
					this.sysProps.setProperty(JBossProperties.SERVER_NAME, arg);
					break;
				}
				{
					String arg = options.getOptarg();
					String name = addPropArgToProps(arg, this.sysProps);
					String value = this.sysProps.getProperty(name);
					if (value.equals("")) {
						this.sysProps.setProperty(name, Boolean.TRUE.toString());
					}
					break;
				}
				{
					String arg = options.getOptarg();
					URL url;
					try {
						File workingDir = new File(currentWorkingDir);
						url = JBossConfigurationUtility.makeURL(arg, workingDir);
					} catch (Exception e) {
						log.error("Failed to parse argument to --properties option: " + options.getOptarg());
						break;
					}
					Properties props = new Properties();
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
			} else if (c == 'b') {
				{
					String arg = options.getOptarg();
					this.sysProps.setProperty(JBossProperties.BIND_ADDRESS, arg);
					break;
				}
				{
					String arg = options.getOptarg();
					this.sysProps.setProperty(JBossProperties.SERVER_NAME, arg);
					break;
				}
				{
					String arg = options.getOptarg();
					String name = addPropArgToProps(arg, this.sysProps);
					String value = this.sysProps.getProperty(name);
					if (value.equals("")) {
						this.sysProps.setProperty(name, Boolean.TRUE.toString());
					}
					break;
				}
				{
					String arg = options.getOptarg();
					URL url;
					try {
						File workingDir = new File(currentWorkingDir);
						url = JBossConfigurationUtility.makeURL(arg, workingDir);
					} catch (Exception e) {
						log.error("Failed to parse argument to --properties option: " + options.getOptarg());
						break;
					}
					Properties props = new Properties();
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