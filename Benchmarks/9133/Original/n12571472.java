class n12571472{
    public static ParsedXML parseXML(URL url) throws ParseException {
        try {
            InputStream is = url.openStream();
            ParsedXML px = parseXML(is);
            is.close();
            return px;
        } catch (IOException e) {
            throw new ParseException("could not read from URL" + url.toString());
        }
    }

}