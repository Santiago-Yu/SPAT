class n6439640{
    public Properties load() {
        Properties lvProperties = new Properties();
        try {
            InputStream lvInputStream = url.openStream();
            lvProperties.load(lvInputStream);
        } catch (Exception e) {
            throw new PropertiesLoadException("Error in load-method:", e);
        }
        return lvProperties;
    }

}