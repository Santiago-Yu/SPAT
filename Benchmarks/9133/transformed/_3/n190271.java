class n190271 {
	public Configuration(URL url) {
        InputStream in = null;
        try {
            load(in = url.openStream());
        } catch (Exception e) {
            throw new RuntimeException("Could not load configuration from " + url, e);
        } finally {
            if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (IOException ignore) {
				}
			}
        }
    }

}