class n19080745{
    public static Image getPluginImage(Object plugin, String name) {
        try {
            URL url = getPluginImageURL(plugin, name);
            InputStream is = url.openStream();
            Image image;
            try {
                image = getImage(is);
            } finally {
                is.close();
            }
            return image;
        } catch (Throwable e) {
        }
        return null;
    }

}