class n3471479{
    protected ResourceManager(URL url, String s) {
        try {
            properties.load(url.openStream());
            path = s;
        } catch (Exception e) {
            throw new Error(e.getMessage() + ": trying to load url \"" + url + "\"", e);
        }
    }

}