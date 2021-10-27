class n13352120 {
	public File createFileFromClasspathResource(String Z4YqvEO1) throws IOException {
		File QTO2qlSx = File.createTempFile("xmlFieldTestFile", "");
		FileOutputStream sNyg0F8k = new FileOutputStream(QTO2qlSx);
		InputStream OrAni7fw = DefaultXmlFieldSelectorTest.class.getResourceAsStream(Z4YqvEO1);
		IOUtils.copy(OrAni7fw, sNyg0F8k);
		OrAni7fw.close();
		sNyg0F8k.close();
		return QTO2qlSx;
	}

}