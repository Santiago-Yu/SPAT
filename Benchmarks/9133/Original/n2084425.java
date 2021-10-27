class n2084425{
    private static boolean isUrlResourceExists(final URL url) {
        try {
            InputStream is = url.openStream();
            try {
                is.close();
            } catch (IOException ioe) {
            }
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

}