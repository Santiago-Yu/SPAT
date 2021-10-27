class n8827647{
    @SuppressWarnings("unchecked")
    private Map getURLMap(String request) throws IOException {
        Map map = null;
        try {
            URL url = new URL(dbURL + request);
            URLConnection conn = url.openConnection();
            conn.connect();
            JSONParser parser = JSONParser.defaultJSONParser();
            InputStreamSource stream = new InputStreamSource(conn.getInputStream(), true);
            map = parser.parse(Map.class, stream);
            stream.destroy();
        } catch (MalformedURLException mue) {
            System.err.println("Internal malformed url Exception: " + mue);
        }
        return map;
    }

}