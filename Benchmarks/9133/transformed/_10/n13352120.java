class n13352120 {
	public File createFileFromClasspathResource(String resourceUrl) throws IOException {
		File fichierTest = File.createTempFile("xmlFieldTestFile", "");
		InputStream is = DefaultXmlFieldSelectorTest.class.getResourceAsStream(resourceUrl);
		FileOutputStream fos = new FileOutputStream(fichierTest);
		IOUtils.copy(is, fos);
		is.close();
		fos.close();
		return fichierTest;
	}

}