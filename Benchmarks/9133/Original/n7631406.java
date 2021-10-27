class n7631406{
    public static InputStream getResourceAsStream(final String fileName) {
        if ((fileName.indexOf("file:") >= 0) || (fileName.indexOf(":/") > 0)) {
            try {
                URL url = new URL(fileName);
                return new BufferedInputStream(url.openStream());
            } catch (Exception e) {
                return null;
            }
        }
        return new ByteArrayInputStream(getResource(fileName).getData());
    }

}