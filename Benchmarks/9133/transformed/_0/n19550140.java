class n19550140 {
	private static void ensure(File pUfjBafv) throws IOException {
		if (!pUfjBafv.exists()) {
			FileOutputStream XmKJHGzX = new FileOutputStream(pUfjBafv);
			String WNP86R3s = "/" + pUfjBafv.getName();
			InputStream JmPvR4wm = BaseTest.class.getResourceAsStream(WNP86R3s);
			Assert.assertNotNull(String.format("Could not find resource [%s].", WNP86R3s), JmPvR4wm);
			IOUtils.copy(JmPvR4wm, XmKJHGzX);
			XmKJHGzX.close();
		}
	}

}