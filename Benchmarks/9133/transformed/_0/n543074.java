class n543074 {
	public Configuration(URL kvBbPnd1) {
        InputStream TdTOvRjf = null;
        try {
            load(TdTOvRjf = kvBbPnd1.openStream());
        } catch (Exception pcArbwTI) {
            throw new RuntimeException("Could not load configuration from " + kvBbPnd1, pcArbwTI);
        } finally {
            if (TdTOvRjf != null) {
                try {
                    TdTOvRjf.close();
                } catch (IOException dSsXu1k7) {
                }
            }
        }
    }

}