class n13683865{
    public URL getResource(String path) throws MalformedURLException {
        if (!path.startsWith("/")) throw new MalformedURLException("Path '" + path + "' does not start with '/'");
        URL url = new URL(myResourceBaseURL, path.substring(1));
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (Throwable t) {
            url = null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable t2) {
                }
            }
        }
        return url;
    }

}