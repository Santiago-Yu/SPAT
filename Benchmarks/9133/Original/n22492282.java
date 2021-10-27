class n22492282{
    public static boolean isODF(URL url) throws IOException {
        InputStream resStream = ODFUtil.findDataInputStream(url.openStream(), ODFUtil.MIMETYPE_FILE);
        if (null == resStream) {
            LOG.debug("mimetype stream not found in ODF package");
            return false;
        }
        String mimetypeContent = IOUtils.toString(resStream);
        return mimetypeContent.startsWith(ODFUtil.MIMETYPE_START);
    }

}