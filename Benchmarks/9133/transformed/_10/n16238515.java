class n16238515 {
	public void register(URL codeBase, String filePath) throws Exception {
		URL url = new URL(codeBase + filePath);
		Properties properties = new Properties();
		properties.load(url.openStream());
		initializeContext(codeBase, properties);
	}

}