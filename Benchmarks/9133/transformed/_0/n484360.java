class n484360 {
	public Configuration(URL P8z9fv5U) {
        InputStream dBYf1GP1 = null;
        try {
            load(dBYf1GP1 = P8z9fv5U.openStream());
        } catch (Exception NZAKVCy8) {
            throw new RuntimeException("Could not load configuration from " + P8z9fv5U, NZAKVCy8);
        } finally {
            if (dBYf1GP1 != null) {
                try {
                    dBYf1GP1.close();
                } catch (IOException I0Nici8k) {
                }
            }
        }
    }

}