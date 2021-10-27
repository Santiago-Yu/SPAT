class n821218 {
	public Configuration(URL E3U2CLnu) {
        InputStream WGYhRiee = null;
        try {
            load(WGYhRiee = E3U2CLnu.openStream());
        } catch (Exception iAgoh0l6) {
            throw new RuntimeException("Could not load configuration from " + E3U2CLnu, iAgoh0l6);
        } finally {
            if (WGYhRiee != null) {
                try {
                    WGYhRiee.close();
                } catch (IOException NpEtZf2G) {
                }
            }
        }
    }

}