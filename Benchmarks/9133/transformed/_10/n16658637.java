class n16658637 {
	private void initUserExtensions(SeleniumConfiguration seleniumConfiguration) throws IOException {
		StringOutputStream s = new StringOutputStream();
		StringBuilder contents = new StringBuilder();
		IOUtils.copy(SeleniumConfiguration.class.getResourceAsStream("default-user-extensions.js"), s);
		contents.append(s.toString());
		File providedUserExtensions = seleniumConfiguration.getFile(ConfigurationPropertyKeys.SELENIUM_USER_EXTENSIONS,
				seleniumConfiguration.getDirectoryConfiguration().getInput(), false);
		if (providedUserExtensions != null) {
			contents.append(FileUtils.readFileToString(providedUserExtensions, null));
		}
		seleniumUserExtensions = new File(seleniumConfiguration.getDirectoryConfiguration().getInput(),
				"user-extensions.js");
		FileUtils.forceMkdir(seleniumUserExtensions.getParentFile());
		FileUtils.writeStringToFile(seleniumUserExtensions, contents.toString(), null);
	}

}