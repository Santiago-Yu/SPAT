class n432090 {
	public Configuration(URL LWxcNhQe) {
        InputStream ZpjnO1gB = null;
        try {
            load(ZpjnO1gB = LWxcNhQe.openStream());
        } catch (Exception u8wNNX6c) {
            throw new RuntimeException("Could not load configuration from " + LWxcNhQe, u8wNNX6c);
        } finally {
            if (ZpjnO1gB != null) {
                try {
                    ZpjnO1gB.close();
                } catch (IOException iXUY4ASH) {
                }
            }
        }
    }

}