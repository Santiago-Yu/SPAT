class n21062468 {
	protected final Properties getResourceProperties(Long id, String baseURL) {
		try {
			URL url = getClass().getResource(baseURL + id + ".properties");
			if (null == url) {
				url = new URL(baseURL + id + ".properties");
			}
			Properties props = new Properties();
			InputStream is = url.openStream();
			props.load(is);
			is.close();
			return props;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}