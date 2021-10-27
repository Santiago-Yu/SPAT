class n435331 {
	public Configuration(URL GpweqbPW) {
        InputStream hksygQn3 = null;
        try {
            load(hksygQn3 = GpweqbPW.openStream());
        } catch (Exception CsTq88C8) {
            throw new RuntimeException("Could not load configuration from " + GpweqbPW, CsTq88C8);
        } finally {
            if (hksygQn3 != null) {
                try {
                    hksygQn3.close();
                } catch (IOException EHiPBFqx) {
                }
            }
        }
    }

}