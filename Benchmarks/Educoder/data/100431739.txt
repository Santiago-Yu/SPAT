    private InputStream getPageStream(String query) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + query + "&rhtml=no");
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream in = connection.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(in);
        return bis;
    }
