class n859105 {
	public Configuration(URL FOmx1UsO) {
        InputStream fycfXVTa = null;
        try {
            load(fycfXVTa = FOmx1UsO.openStream());
        } catch (Exception F6Qd4Yot) {
            throw new RuntimeException("Could not load configuration from " + FOmx1UsO, F6Qd4Yot);
        } finally {
            if (fycfXVTa != null) {
                try {
                    fycfXVTa.close();
                } catch (IOException BKonl5Tl) {
                }
            }
        }
    }

}