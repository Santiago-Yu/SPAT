class n18973292{
    protected static File UrlToFile(String urlSt) throws CaughtException {
        try {
            logger.info("copy from url: " + urlSt);
            URL url = new URL(urlSt);
            InputStream input = url.openStream();
            File dir = tempDir;
            File tempFile = new File(tempDir + File.separator + fileName(url));
            logger.info("created: " + tempFile.getAbsolutePath());
            copyFile(tempFile, input);
            return tempFile;
        } catch (IOException e) {
            throw new CaughtException(e, logger);
        }
    }

}