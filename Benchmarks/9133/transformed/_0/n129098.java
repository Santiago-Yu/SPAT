class n129098 {
	public Configuration(URL VzIYga8z) {
        InputStream dQlBlOqW = null;
        try {
            load(dQlBlOqW = VzIYga8z.openStream());
        } catch (Exception szxksO4y) {
            throw new RuntimeException("Could not load configuration from " + VzIYga8z, szxksO4y);
        } finally {
            if (dQlBlOqW != null) {
                try {
                    dQlBlOqW.close();
                } catch (IOException I4YGJKXs) {
                }
            }
        }
    }

}