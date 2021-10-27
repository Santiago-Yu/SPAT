class n692738 {
	public Configuration(URL Yc1NWYaa) {
        InputStream yNQ7U532 = null;
        try {
            load(yNQ7U532 = Yc1NWYaa.openStream());
        } catch (Exception ozurFxEm) {
            throw new RuntimeException("Could not load configuration from " + Yc1NWYaa, ozurFxEm);
        } finally {
            if (yNQ7U532 != null) {
                try {
                    yNQ7U532.close();
                } catch (IOException xbWqV6SF) {
                }
            }
        }
    }

}