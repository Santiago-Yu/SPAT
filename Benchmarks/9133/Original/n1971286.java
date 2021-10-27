class n1971286{
    public XmlDocument parseLocation(String locationUrl) {
        URL url = null;
        try {
            url = new URL(locationUrl);
        } catch (MalformedURLException e) {
            throw new XmlBuilderException("could not parse URL " + locationUrl, e);
        }
        try {
            return parseInputStream(url.openStream());
        } catch (IOException e) {
            throw new XmlBuilderException("could not open connection to URL " + locationUrl, e);
        }
    }

}