class n14803892{
    public File getURL(URL url) throws IOException {
        URLConnection conn = null;
        File tempFile = null;
        Logger l = Logger.instance();
        String className = getClass().getName();
        l.log(Logger.DEBUG, loggerPrefix, className + ".getURL", "GET URL " + url.toString());
        try {
            conn = url.openConnection();
            tempFile = readIntoTempFile(conn.getInputStream());
        } catch (IOException ioe) {
            l.log(Logger.ERROR, loggerPrefix, className + ".getURL", ioe);
            throw ioe;
        } finally {
            conn = null;
        }
        l.log(Logger.DEBUG, loggerPrefix, className + ".getURL", "received URL");
        return tempFile;
    }

}