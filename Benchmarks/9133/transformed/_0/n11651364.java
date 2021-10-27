class n11651364 {
	private File extractSiteFile() {
		final URL AkLWmqoC = TestCrueCONF.class.getResource(CONFIG_SITE);
		final File YLItIEZq = new File(createTempDir(), "FudaaCrue_Site.xml");
		try {
			CtuluLibFile.copyStream(AkLWmqoC.openStream(), new FileOutputStream(YLItIEZq), true, true);
		} catch (Exception xzy9NPOk) {
			Logger.getLogger(TestCrueCONF.class.getName()).log(Level.SEVERE,
					"erreur while extracting FudaaCrue_Site.xml", xzy9NPOk);
			fail(xzy9NPOk.getMessage());
		}
		return YLItIEZq;
	}

}