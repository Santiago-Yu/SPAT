class n8827646{
    @SuppressWarnings("unchecked")
    private List getURLList(String request) throws IOException {
        List list = null;
        try {
            URL url = new URL(dbURL + request);
            URLConnection conn = url.openConnection();
            conn.connect();
            JSONParser parser = JSONParser.defaultJSONParser();
            InputStreamSource stream = new InputStreamSource(conn.getInputStream(), true);
            list = parser.parse(List.class, stream);
            stream.destroy();
        } catch (MalformedURLException mue) {
            System.err.println("Internal malformed url Exception: " + mue);
        }
        return list;
    }

}