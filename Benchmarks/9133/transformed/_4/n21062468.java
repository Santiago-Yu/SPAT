class n21062468 {
	protected final Properties getResourceProperties(Long id, String baseURL) {
		try {
			URL url = getClass().getResource(baseURL + id + ".properties");
			url = (url == null) ? new URL(baseURL + id + ".properties") : url;
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