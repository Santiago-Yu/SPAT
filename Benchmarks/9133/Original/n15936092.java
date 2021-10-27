class n15936092{
    public java.io.Serializable getContent() throws org.osid.repository.RepositoryException {
        logger.logMethod();
        if (!this.cached) {
            logger.logTrace("not cached.. getting content");
            Object object = this.asset.getContent();
            if (object instanceof String) {
                String s = (String) object;
                if (s.startsWith("http://")) {
                    try {
                        java.net.URL url = new java.net.URL(s);
                        java.io.InputStream is = url.openStream();
                        java.io.File file = getCacheFile();
                        java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
                        int len;
                        byte[] b = new byte[10240];
                        this.length = 0;
                        while ((len = is.read(b)) >= 0) {
                            fos.write(b, 0, len);
                            this.length += len;
                        }
                        fos.close();
                        is.close();
                        java.net.URLConnection urlc = new java.net.URL(s).openConnection();
                        this.lastModified = urlc.getLastModified();
                        this.mimeType = urlc.getContentType();
                    } catch (java.io.IOException ie) {
                        logger.logError("error writing file", ie);
                    }
                }
            }
            this.cached = true;
        } else {
            logger.logTrace("cached..");
        }
        try {
            return (new SerializableInputStream(new java.io.FileInputStream(getCacheFile())));
        } catch (java.io.IOException ie) {
            logger.logError("cannot get content", ie);
            throw new org.osid.repository.RepositoryException(org.osid.repository.RepositoryException.OPERATION_FAILED);
        }
    }

}