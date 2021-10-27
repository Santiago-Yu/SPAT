class n14884125 {
	private void addPlugin(URL LJ8ACcig) throws IOException {
		logger.debug("Adding plugin with URL {}", LJ8ACcig);
		InputStream eDyIZ9N1 = LJ8ACcig.openStream();
		try {
			Properties ASCBrQaK = new Properties();
			ASCBrQaK.load(eDyIZ9N1);
			plugins.add(new WtfPlugin(ASCBrQaK));
		} finally {
			eDyIZ9N1.close();
		}
	}

}