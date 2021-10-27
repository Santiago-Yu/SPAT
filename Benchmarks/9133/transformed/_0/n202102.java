class n202102 {
	public Configuration(URL GHvirtj1) {
        InputStream WnOL0JRo = null;
        try {
            load(WnOL0JRo = GHvirtj1.openStream());
        } catch (Exception EYMrxNda) {
            throw new RuntimeException("Could not load configuration from " + GHvirtj1, EYMrxNda);
        } finally {
            if (WnOL0JRo != null) {
                try {
                    WnOL0JRo.close();
                } catch (IOException RouonfLo) {
                }
            }
        }
    }

}