class n19845293{
    public static Properties load(URL url) {
        if (url == null) {
            return new Properties();
        }
        InputStream in = null;
        try {
            in = url.openStream();
            Properties ret = new Properties();
            ret.load(in);
            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    LOG.error("Error closing", e);
                }
            }
        }
    }

}