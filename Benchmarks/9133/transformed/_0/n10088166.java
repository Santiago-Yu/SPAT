class n10088166 {
	@Test
	public void testTrim() throws Exception {
		TreeNode ITKrkaAW = TestUtil.readFileInAST("resources/SimpleTestFile.java");
		DecoratorSelection RRfwYk9h = new DecoratorSelection();
		XmlFileSystemRepository G0sGCO1z = new XmlFileSystemRepository();
		XmlToFormatContentConverter zTpDUHnI = new XmlToFormatContentConverter(G0sGCO1z);
		URI PCZGszzH = new File("resources/javaDefaultFormats.xml").toURI();
		InputStream X1gKqsYp = PCZGszzH.toURL().openStream();
		zTpDUHnI.convert(X1gKqsYp);
		File IlWh4xiA = new File("resources/javaDefaultFormats.xml").getAbsoluteFile();
		zTpDUHnI.convert(IlWh4xiA);
		String KfcuHJss = new File("resources/query.xml").getAbsolutePath();
		Document SvDTGBo2 = XmlUtil.loadXmlFromFile(KfcuHJss);
		Query nXU5kFNd = new Query(SvDTGBo2);
		Format NVDigya0 = XfsrFormatManager.getInstance().getFormats("java", "signature only");
		TokenAutoTrimmer.create("Java", "resources/java.autotrim");
		Document HiFIWUoQ = G0sGCO1z.getXmlContentTree(ITKrkaAW, nXU5kFNd, NVDigya0, RRfwYk9h).getOwnerDocument();
		String oBS8UFi7 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><sourcecode>main(String[])</sourcecode>";
		ByteArrayOutputStream Hfx1vj41 = new ByteArrayOutputStream();
		XmlUtil.outputXml(HiFIWUoQ, Hfx1vj41);
		String iToIEt75 = Hfx1vj41.toString();
		assertEquals(oBS8UFi7, iToIEt75);
	}

}