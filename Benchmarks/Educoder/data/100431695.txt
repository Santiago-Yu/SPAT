    protected static Parser buildParser(URL url) throws IOException, ParserException {
        Parser parser;
        URLConnection connection = openConnection(url);
        if (!(connection instanceof HttpURLConnection) || ((HttpURLConnection) connection).getResponseCode() == 200) {
            parser = new Parser(connection);
        } else {
            parser = null;
        }
        return parser;
    }
