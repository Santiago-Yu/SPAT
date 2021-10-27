class n22631236{
    public static Document getDocument(URL url, boolean validate) throws QTIParseException {
        try {
            return getDocument(new InputSource(url.openStream()), validate, null);
        } catch (IOException ex) {
            throw new QTIParseException(ex);
        }
    }

}