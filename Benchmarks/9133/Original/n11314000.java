class n11314000{
    public static String getFileText(URL _url) {
        try {
            InputStream input = _url.openStream();
            String content = IOUtils.toString(input);
            IOUtils.closeQuietly(input);
            return content;
        } catch (Exception err) {
            LOG.error(_url.toString(), err);
            return "";
        }
    }

}