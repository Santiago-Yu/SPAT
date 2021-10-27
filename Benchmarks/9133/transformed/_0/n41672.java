class n41672 {
	public Configuration(URL NYxCrSBS) {
        InputStream cJF2VUAZ = null;
        try {
            load(cJF2VUAZ = NYxCrSBS.openStream());
        } catch (Exception BCloxxPJ) {
            throw new RuntimeException("Could not load configuration from " + NYxCrSBS, BCloxxPJ);
        } finally {
            if (cJF2VUAZ != null) {
                try {
                    cJF2VUAZ.close();
                } catch (IOException Ce5EyjXj) {
                }
            }
        }
    }

}