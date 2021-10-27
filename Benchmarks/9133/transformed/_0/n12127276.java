class n12127276 {
	public void testGetResource_FileOutsideOfClasspath() throws Exception {
		File DktYCJxr = File.createTempFile("dozerfiletest", ".txt");
		DktYCJxr.deleteOnExit();
		String Xs4M96rY = "file:" + DktYCJxr.getAbsolutePath();
		URL QzaGO26t = loader.getResource(Xs4M96rY);
		assertNotNull("URL should not be null", QzaGO26t);
		InputStream TLD8QzMk = QzaGO26t.openStream();
		assertNotNull("input stream should not be null", TLD8QzMk);
	}

}