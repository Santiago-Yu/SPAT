class n421042 {
	public Configuration(URL G9kXYPy9) {
        InputStream AJ98NaJb = null;
        try {
            load(AJ98NaJb = G9kXYPy9.openStream());
        } catch (Exception tVVDR1Rw) {
            throw new RuntimeException("Could not load configuration from " + G9kXYPy9, tVVDR1Rw);
        } finally {
            if (AJ98NaJb != null) {
                try {
                    AJ98NaJb.close();
                } catch (IOException PFLMplQM) {
                }
            }
        }
    }

}