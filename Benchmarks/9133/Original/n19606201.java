class n19606201{
    public static Collection<String> readXML(Bundle declaringBundle, URL url) throws XmlPullParserException {
        try {
            return readXML(declaringBundle, url.openStream());
        } catch (IOException e) {
            throw new XmlPullParserException("Could not open \"" + url + "\" got exception:" + e.getLocalizedMessage());
        }
    }

}