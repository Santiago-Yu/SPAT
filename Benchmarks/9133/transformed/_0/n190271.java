class n190271 {
	public Configuration(URL xjCz44TM) {
        InputStream TSAD7h5m = null;
        try {
            load(TSAD7h5m = xjCz44TM.openStream());
        } catch (Exception uZNAzkbv) {
            throw new RuntimeException("Could not load configuration from " + xjCz44TM, uZNAzkbv);
        } finally {
            if (TSAD7h5m != null) {
                try {
                    TSAD7h5m.close();
                } catch (IOException f8QFpI5a) {
                }
            }
        }
    }

}