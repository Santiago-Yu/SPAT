class n1831863{
    public Document searchRelease(String id) throws Exception {
        Document doc = null;
        URL url = new URL("http://" + disgogsUrl + "/release/" + id + "?f=xml&api_key=" + apiKey[0]);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.addRequestProperty("Accept-Encoding", "gzip");
        BufferedReader ir = null;
        if (uc.getInputStream() != null) {
            ir = new BufferedReader(new InputStreamReader(new GZIPInputStream(uc.getInputStream()), "ISO8859_1"));
            SAXBuilder builder = new SAXBuilder();
            doc = builder.build(ir);
        }
        return doc;
    }

}