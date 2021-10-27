class n18973299{
    protected static File UrlGzipToAFile(File dir, String urlSt, String fileName) throws CaughtException {
        try {
            URL url = new URL(urlSt);
            InputStream zipped = url.openStream();
            InputStream unzipped = new GZIPInputStream(zipped);
            File tempFile = new File(dir, fileName);
            copyFile(tempFile, unzipped);
            return tempFile;
        } catch (IOException e) {
            throw new CaughtException(e, logger);
        }
    }

}