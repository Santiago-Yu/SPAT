class n400275 {
	public Configuration(URL I60yFQ2S) {
        InputStream mIegf4eq = null;
        try {
            load(mIegf4eq = I60yFQ2S.openStream());
        } catch (Exception qKFORADN) {
            throw new RuntimeException("Could not load configuration from " + I60yFQ2S, qKFORADN);
        } finally {
            if (mIegf4eq != null) {
                try {
                    mIegf4eq.close();
                } catch (IOException AsIOWLr8) {
                }
            }
        }
    }

}