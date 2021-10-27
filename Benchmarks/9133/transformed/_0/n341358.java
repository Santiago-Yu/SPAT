class n341358 {
	public Configuration(URL lM6jFPb5) {
        InputStream RWYTLE0t = null;
        try {
            load(RWYTLE0t = lM6jFPb5.openStream());
        } catch (Exception dw6oCt3q) {
            throw new RuntimeException("Could not load configuration from " + lM6jFPb5, dw6oCt3q);
        } finally {
            if (RWYTLE0t != null) {
                try {
                    RWYTLE0t.close();
                } catch (IOException fp8UOkpR) {
                }
            }
        }
    }

}