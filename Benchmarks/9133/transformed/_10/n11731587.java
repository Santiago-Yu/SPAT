class n11731587 {
	public File createFileFromClasspathResource(String resourceUrl) throws IOException {
		File fichierTest = File.createTempFile("xmlFieldTestFile", "");
		InputStream is = XmlFieldDomSelectorTest.class.getResourceAsStream(resourceUrl);
		FileOutputStream fos = new FileOutputStream(fichierTest);
		IOUtils.copy(is, fos);
		is.close();
		fos.close();
		return fichierTest;
	}

}