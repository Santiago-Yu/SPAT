class n22567370{
    public static Reader createReader(TreeLogger logger, URL url) throws UnableToCompleteException {
        try {
            return new InputStreamReader(url.openStream());
        } catch (IOException e) {
            logger.log(TreeLogger.ERROR, "Unable to open resource: " + url, e);
            throw new UnableToCompleteException();
        }
    }

}