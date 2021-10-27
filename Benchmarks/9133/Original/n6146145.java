class n6146145{
    public void testSystemPropertyConnector() throws Exception {
        final String rootFolderPath = "test/ConnectorTest/fs/".toLowerCase();
        final Connector connector = new SystemPropertyConnector();
        final ContentResolver contentResolver = new UnionContentResolver();
        final FSContentResolver fsContentResolver = new FSContentResolver();
        fsContentResolver.setRootFolderPath(rootFolderPath);
        contentResolver.addContentResolver(fsContentResolver);
        contentResolver.addContentResolver(new ClasspathContentResolver());
        connector.setContentResolver(contentResolver);
        String resultString;
        byte[] resultContent;
        Object resultObject;
        resultString = connector.getString("helloWorldPath");
        assertNull(resultString);
        resultContent = connector.getContent("helloWorldPath");
        assertNull(resultContent);
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
        System.setProperty("helloWorldPath", "org/settings4j/connector/HelloWorld2.txt");
        resultString = connector.getString("helloWorldPath");
        assertNotNull(resultString);
        assertEquals("org/settings4j/connector/HelloWorld2.txt", resultString);
        resultContent = connector.getContent("helloWorldPath");
        assertNotNull(resultContent);
        assertEquals("Hello World 2", new String(resultContent, "UTF-8"));
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
        System.setProperty("helloWorldPath", "file:org/settings4j/connector/HelloWorld2.txt");
        resultString = connector.getString("helloWorldPath");
        assertNotNull(resultString);
        assertEquals("file:org/settings4j/connector/HelloWorld2.txt", resultString);
        resultContent = connector.getContent("helloWorldPath");
        assertNull(resultObject);
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
        System.setProperty("helloWorldPath", "classpath:org/settings4j/connector/HelloWorld2.txt");
        resultString = connector.getString("helloWorldPath");
        assertNotNull(resultString);
        assertEquals("classpath:org/settings4j/connector/HelloWorld2.txt", resultString);
        resultContent = connector.getContent("helloWorldPath");
        assertNotNull(resultContent);
        assertEquals("Hello World 2", new String(resultContent, "UTF-8"));
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
        final InputStream helloWorldIS = new ByteArrayInputStream("Hello World 2 - Test".getBytes("UTF-8"));
        FileUtils.forceMkdir(new File(rootFolderPath + "/org/settings4j/connector"));
        final String helloWorldPath = rootFolderPath + "/org/settings4j/connector/HelloWorld2.txt";
        final FileOutputStream fileOutputStream = new FileOutputStream(new File(helloWorldPath));
        IOUtils.copy(helloWorldIS, fileOutputStream);
        IOUtils.closeQuietly(helloWorldIS);
        IOUtils.closeQuietly(fileOutputStream);
        LOG.info("helloWorld2Path: " + helloWorldPath);
        System.setProperty("helloWorldPath", "file:org/settings4j/connector/HelloWorld2.txt");
        resultString = connector.getString("helloWorldPath");
        assertNotNull(resultString);
        assertEquals("file:org/settings4j/connector/HelloWorld2.txt", resultString);
        resultContent = connector.getContent("helloWorldPath");
        assertNotNull(resultContent);
        assertEquals("Hello World 2 - Test", new String(resultContent, "UTF-8"));
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
        System.setProperty("helloWorldPath", "org/settings4j/connector/HelloWorld2.txt");
        resultString = connector.getString("helloWorldPath");
        assertNotNull(resultString);
        assertEquals("org/settings4j/connector/HelloWorld2.txt", resultString);
        resultContent = connector.getContent("helloWorldPath");
        resultContent = connector.getContent("helloWorldPath");
        assertNotNull(resultContent);
        assertEquals("Hello World 2 - Test", new String(resultContent, "UTF-8"));
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
        System.setProperty("helloWorldPath", "classpath:org/settings4j/connector/HelloWorld2.txt");
        resultString = connector.getString("helloWorldPath");
        assertNotNull(resultString);
        assertEquals("classpath:org/settings4j/connector/HelloWorld2.txt", resultString);
        resultContent = connector.getContent("helloWorldPath");
        assertNotNull(resultContent);
        assertEquals("Hello World 2", new String(resultContent, "UTF-8"));
        resultObject = connector.getObject("helloWorldPath");
        assertNull(resultObject);
    }

}