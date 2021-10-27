class n11731587 {
	public File createFileFromClasspathResource(String DkTHgMz5) throws IOException {
		File NJuSFa06 = File.createTempFile("xmlFieldTestFile", "");
		FileOutputStream e7WfNHO1 = new FileOutputStream(NJuSFa06);
		InputStream itmffsbQ = XmlFieldDomSelectorTest.class.getResourceAsStream(DkTHgMz5);
		IOUtils.copy(itmffsbQ, e7WfNHO1);
		itmffsbQ.close();
		e7WfNHO1.close();
		return NJuSFa06;
	}

}