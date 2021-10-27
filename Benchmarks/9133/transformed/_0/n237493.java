class n237493 {
	public Configuration(URL bKszzsQO) {
        InputStream WFxCWNtO = null;
        try {
            load(WFxCWNtO = bKszzsQO.openStream());
        } catch (Exception RtsSTCzQ) {
            throw new RuntimeException("Could not load configuration from " + bKszzsQO, RtsSTCzQ);
        } finally {
            if (WFxCWNtO != null) {
                try {
                    WFxCWNtO.close();
                } catch (IOException diTI0rZ3) {
                }
            }
        }
    }

}