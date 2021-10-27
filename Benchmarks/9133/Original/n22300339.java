class n22300339{
    public static String getDocumentAsString(URL url) throws IOException {
        StringBuffer result = new StringBuffer();
        InputStream inStream = url.openStream();
        int character;
        while ((character = inStream.read()) != -1) {
            result.append((char) character);
        }
        return result.toString();
    }

}