class n406170 {
	public Configuration(URL ixgD2lil) {
        InputStream OFKH81UU = null;
        try {
            load(OFKH81UU = ixgD2lil.openStream());
        } catch (Exception jHeyj2cg) {
            throw new RuntimeException("Could not load configuration from " + ixgD2lil, jHeyj2cg);
        } finally {
            if (OFKH81UU != null) {
                try {
                    OFKH81UU.close();
                } catch (IOException yYTsXCqW) {
                }
            }
        }
    }

}