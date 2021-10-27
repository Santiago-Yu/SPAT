class n569033 {
	public Configuration(URL DIzzDOWX) {
        InputStream etVWvVqx = null;
        try {
            load(etVWvVqx = DIzzDOWX.openStream());
        } catch (Exception fuFQ2gO9) {
            throw new RuntimeException("Could not load configuration from " + DIzzDOWX, fuFQ2gO9);
        } finally {
            if (etVWvVqx != null) {
                try {
                    etVWvVqx.close();
                } catch (IOException VwijJGHT) {
                }
            }
        }
    }

}