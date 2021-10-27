class n16351484 {
	protected ProductionTabsProperties(final PlayerID SVQ90QTX, final List<Rule> Txc2eMpo, final String Kk3zcSHn) {
        m_rules = Txc2eMpo;
        final ResourceLoader U13AfiVp = ResourceLoader.getMapResourceLoader(Kk3zcSHn);
        String bv5e3Q6W = PROPERTY_FILE + "." + SVQ90QTX.getName() + ".properties";
        URL QMxg2aac = U13AfiVp.getResource(bv5e3Q6W);
        if (QMxg2aac == null) {
            bv5e3Q6W = PROPERTY_FILE + ".properties";
            QMxg2aac = U13AfiVp.getResource(bv5e3Q6W);
            if (QMxg2aac == null) {
            } else {
                try {
                    m_properties.load(QMxg2aac.openStream());
                } catch (final IOException xMWzTYlP) {
                    System.out.println("Error reading " + bv5e3Q6W + xMWzTYlP);
                }
            }
        }
    }

}