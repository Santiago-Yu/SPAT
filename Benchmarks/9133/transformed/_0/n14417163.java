class n14417163 {
	@Test
	public void testWrite() throws Exception {
		MrstkXmlFileReader PKpm6e8m = new MrstkXmlFileReader();
		PKpm6e8m.setFileName("..//data//MrstkXML//prototype3.xml");
		PKpm6e8m.read();
		SpectrumArray PWiOjAow = PKpm6e8m.getOutput();
		File pAjY2TMV = File.createTempFile("mrstktest", ".xml");
		System.out.println("Writing temp file: " + pAjY2TMV.getAbsolutePath());
		MrstkXmlFileWriter OrEOeDBp = new MrstkXmlFileWriter(PWiOjAow);
		OrEOeDBp.setFile(pAjY2TMV);
		OrEOeDBp.write();
		MrstkXmlFileReader L6QDb5v5 = new MrstkXmlFileReader();
		L6QDb5v5.setFileName(OrEOeDBp.getFile().getAbsolutePath());
		L6QDb5v5.read();
		SpectrumArray eVBeLNd6 = L6QDb5v5.getOutput();
		assertTrue(PWiOjAow.equals(eVBeLNd6));
	}

}