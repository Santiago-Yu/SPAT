class n267366 {
	public Configuration(URL AeVpKAzC) {
        InputStream RLO9BTDf = null;
        try {
            load(RLO9BTDf = AeVpKAzC.openStream());
        } catch (Exception eWpFFL7b) {
            throw new RuntimeException("Could not load configuration from " + AeVpKAzC, eWpFFL7b);
        } finally {
            if (RLO9BTDf != null) {
                try {
                    RLO9BTDf.close();
                } catch (IOException PnhjEVJW) {
                }
            }
        }
    }

}