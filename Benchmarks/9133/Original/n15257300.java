class n15257300{
    private String readFile(String urlFileString) throws IOException {
        URL url = new URL(urlFileString);
        VizDebugUtils.debug("url: " + url.toString());
        InputStream stream = url.openStream();
        Reader reader = new InputStreamReader(stream, "iso-8859-1");
        StringWriter writer = new StringWriter();
        StreamUtils.transfer(reader, writer);
        stream.close();
        return writer.toString();
    }

}