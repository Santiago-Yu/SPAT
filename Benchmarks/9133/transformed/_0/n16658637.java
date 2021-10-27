class n16658637 {
	private void initUserExtensions(SeleniumConfiguration zdEJatRt) throws IOException {
		StringBuilder qBzwDePh = new StringBuilder();
		StringOutputStream zK8XyqU0 = new StringOutputStream();
		IOUtils.copy(SeleniumConfiguration.class.getResourceAsStream("default-user-extensions.js"), zK8XyqU0);
		qBzwDePh.append(zK8XyqU0.toString());
		File sdM44QfE = zdEJatRt.getFile(ConfigurationPropertyKeys.SELENIUM_USER_EXTENSIONS,
				zdEJatRt.getDirectoryConfiguration().getInput(), false);
		if (sdM44QfE != null) {
			qBzwDePh.append(FileUtils.readFileToString(sdM44QfE, null));
		}
		seleniumUserExtensions = new File(zdEJatRt.getDirectoryConfiguration().getInput(), "user-extensions.js");
		FileUtils.forceMkdir(seleniumUserExtensions.getParentFile());
		FileUtils.writeStringToFile(seleniumUserExtensions, qBzwDePh.toString(), null);
	}

}