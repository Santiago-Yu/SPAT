class n6242862{
    public void reload() throws SAXException, IOException {
        if (url != null) {
            java.io.InputStream is = url.openStream();
            configDoc = builder.parse(is);
            is.close();
            System.out.println("XML config file read correctly from " + url);
        } else {
            configDoc = builder.parse(configFile);
            System.out.println("XML config file read correctly from " + configFile);
        }
    }

}