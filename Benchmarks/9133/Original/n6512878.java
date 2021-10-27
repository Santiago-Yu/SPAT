class n6512878{
    public static String readAsString(final URL url) throws java.io.IOException {
        InputStream inputStream = url.openStream();
        try {
            return readAsString(inputStream);
        } finally {
            try {
                inputStream.close();
            } catch (Throwable t) {
            }
        }
    }

}