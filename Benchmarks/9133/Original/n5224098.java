class n5224098{
    private static Properties load(URL url) {
        Properties props = new Properties();
        try {
            InputStream is = null;
            try {
                is = url.openStream();
                props.load(is);
            } finally {
                is.close();
            }
        } catch (IOException e) {
        }
        return props;
    }

}