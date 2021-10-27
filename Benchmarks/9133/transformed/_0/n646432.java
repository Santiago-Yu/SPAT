class n646432 {
	public Configuration(URL LQ0FIy90) {
        InputStream e2QtYsYb = null;
        try {
            load(e2QtYsYb = LQ0FIy90.openStream());
        } catch (Exception sCl0qkRP) {
            throw new RuntimeException("Could not load configuration from " + LQ0FIy90, sCl0qkRP);
        } finally {
            if (e2QtYsYb != null) {
                try {
                    e2QtYsYb.close();
                } catch (IOException G3CM0V5w) {
                }
            }
        }
    }

}