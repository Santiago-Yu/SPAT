class n21741649{
    private InputStream getInputStream() throws URISyntaxException, MalformedURLException, IOException {
        InputStream inStream = null;
        try {
            URL url = new URI(wsdlFile).toURL();
            URLConnection connection = url.openConnection();
            connection.connect();
            inStream = connection.getInputStream();
        } catch (IllegalArgumentException ex) {
            inStream = new FileInputStream(wsdlFile);
        }
        return inStream;
    }

}