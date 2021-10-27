class n1342927{
    public static InputStream getResourceAsStream(String resourceName) {
        try {
            URL url = getEmbeddedFileUrl(WS_SEP + resourceName);
            if (url != null) {
                return url.openStream();
            }
        } catch (MalformedURLException e) {
            GdtAndroidPlugin.getLogger().logError(e, "Failed to read stream '%s'", resourceName);
        } catch (IOException e) {
            GdtAndroidPlugin.getLogger().logError(e, "Failed to read stream '%s'", resourceName);
        }
        return null;
    }

}