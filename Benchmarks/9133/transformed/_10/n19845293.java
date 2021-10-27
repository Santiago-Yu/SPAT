class n19845293 {
	public static Properties load(URL url) {
		InputStream in = null;
		if (url == null) {
			return new Properties();
		}
		try {
			Properties ret = new Properties();
			in = url.openStream();
			ret.load(in);
			return ret;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LOG.error("Error closing", e);
				}
			}
		}
	}

}