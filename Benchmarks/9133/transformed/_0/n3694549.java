class n3694549 {
	private File getTestFile() {
		final URL v2PMIIUz = TestCrueLOG.class.getResource(FICHIER_TEST_XML);
		final File wNXvqaAh = new File(createTempDir(), "resultat.rtfa.xml");
		try {
			CtuluLibFile.copyStream(v2PMIIUz.openStream(), new FileOutputStream(wNXvqaAh), true, true);
		} catch (Exception Iz5QOUZL) {
			Iz5QOUZL.printStackTrace();
			fail();
		}
		return wNXvqaAh;
	}

}