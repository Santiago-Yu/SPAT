    public Resource parse(URL url, IRDFContainer target) throws RDFException, IOException {
        parseURL = url;
        URLConnection connection = url.openConnection();
        if (charset == null) {
            charset = Charset.forName("UTF-8");
        }
        Reader reader = new InputStreamReader(connection.getInputStream(), charset);
        return internalParse(reader, target);
    }
