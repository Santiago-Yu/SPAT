class n19360483 {
	private void initLogging() {
		File logging = new File(App.getHome(), "logging.properties");
		FileInputStream input = null;
		if (!logging.exists()) {
			InputStream input = getClass().getResourceAsStream("logging.properties-setup");
			OutputStream output = null;
			try {
				output = new FileOutputStream(logging);
				IOUtils.copy(input, output);
			} catch (Exception ex) {
			} finally {
				IOUtils.closeQuietly(input);
				IOUtils.closeQuietly(output);
			}
		}
		try {
			input = new FileInputStream(logging);
			LogManager.getLogManager().readConfiguration(input);
		} catch (Exception ex) {
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

}