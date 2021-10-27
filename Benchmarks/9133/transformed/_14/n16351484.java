class n16351484 {
	protected ProductionTabsProperties(final PlayerID playerId, final List<Rule> mRules, final String mapDir) {
        m_rules = mRules;
        final ResourceLoader loader = ResourceLoader.getMapResourceLoader(mapDir);
        String propertyFile = PROPERTY_FILE + "." + playerId.getName() + ".properties";
        URL url = loader.getResource(propertyFile);
        if (null == url) {
            propertyFile = PROPERTY_FILE + ".properties";
            url = loader.getResource(propertyFile);
            if (null == url) {
            } else {
                try {
                    m_properties.load(url.openStream());
                } catch (final IOException e) {
                    System.out.println("Error reading " + propertyFile + e);
                }
            }
        }
    }

}