class n10088166{
    @Test
    public void testTrim() throws Exception {
        TreeNode ast = TestUtil.readFileInAST("resources/SimpleTestFile.java");
        DecoratorSelection ds = new DecoratorSelection();
        XmlFileSystemRepository rep = new XmlFileSystemRepository();
        XmlToFormatContentConverter converter = new XmlToFormatContentConverter(rep);
        URI url = new File("resources/javaDefaultFormats.xml").toURI();
        InputStream is = url.toURL().openStream();
        converter.convert(is);
        File f = new File("resources/javaDefaultFormats.xml").getAbsoluteFile();
        converter.convert(f);
        String string = new File("resources/query.xml").getAbsolutePath();
        Document qDoc = XmlUtil.loadXmlFromFile(string);
        Query query = new Query(qDoc);
        Format format = XfsrFormatManager.getInstance().getFormats("java", "signature only");
        TokenAutoTrimmer.create("Java", "resources/java.autotrim");
        Document doc = rep.getXmlContentTree(ast, query, format, ds).getOwnerDocument();
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><sourcecode>main(String[])</sourcecode>";
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XmlUtil.outputXml(doc, bout);
        String actual = bout.toString();
        assertEquals(expected, actual);
    }

}