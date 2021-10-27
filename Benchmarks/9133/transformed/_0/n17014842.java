class n17014842 {
	private String createDefaultRepoConf() throws IOException {
		InputStream EPsOB5sd = getClass().getResourceAsStream(REPO_CONF_PATH);
		File zBQu31m9 = File.createTempFile("repository", "xml");
		zBQu31m9.deleteOnExit();
		IOUtils.copy(EPsOB5sd, new FileOutputStream(zBQu31m9));
		return zBQu31m9.getAbsolutePath();
	}

}