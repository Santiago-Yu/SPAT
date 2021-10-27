class n4293344{
    public ResourceBundle getResources() {
        if (resources == null) {
            String lang = userProps.getProperty("language");
            lang = "en";
            try {
                URL myurl = getResource("Resources_" + lang.trim() + ".properties");
                InputStream in = myurl.openStream();
                resources = new PropertyResourceBundle(in);
                in.close();
            } catch (Exception ex) {
                System.err.println("Error loading Resources");
                return null;
            }
        }
        return resources;
    }

}