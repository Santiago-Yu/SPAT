    public void readFile(URL url) throws PedroException, IOException, ParserConfigurationException, SAXException {
        this.zipFileName = url.toString();
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        unzipNativeFormatFile(inputStream);
        parseAlertFiles();
        deleteAlertFiles();
    }
