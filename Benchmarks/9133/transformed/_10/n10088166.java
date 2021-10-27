class n10088166 {
	@Test
	public void testTrim() throws Exception {
		DecoratorSelection ds = new DecoratorSelection();
		TreeNode ast = TestUtil.readFileInAST("resources/SimpleTestFile.java");
		XmlFileSystemRepository rep = new XmlFileSystemRepository();
		URI url = new File("resources/javaDefaultFormats.xml").toURI();
		XmlToFormatContentConverter converter = new XmlToFormatContentConverter(rep);
		InputStream is = url.toURL().openStream();
		converter.convert(is);
		File f = new File("resources/javaDefaultFormats.xml").getAbsoluteFile();
		converter.convert(f);
		String string = new File("resources/query.xml").getAbsolutePath();
		Document qDoc = XmlUtil.loadXmlFromFile(string);
		Format format = XfsrFormatManager.getInstance().getFormats("java", "signature only");
		Query query = new Query(qDoc);
		TokenAutoTrimmer.create("Java", "resources/java.autotrim");
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><sourcecode>main(String[])</sourcecode>";
		Document doc = rep.getXmlContentTree(ast, query, format, ds).getOwnerDocument();
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		XmlUtil.outputXml(doc, bout);
		String actual = bout.toString();
		assertEquals(expected, actual);
	}

}