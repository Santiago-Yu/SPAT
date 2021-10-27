class n11793834 {
	public static void addProviders(URL url) {
		Properties prop = new Properties();
		Reader reader = null;
		try {
			reader = new InputStreamReader(url.openStream());
			prop.load(reader);
		} catch (Throwable t) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Throwable t) {
				}
			}
		}
		for (Map.Entry<Object, Object> entry : prop.entrySet()) {
			try {
				Class<?> cla = Class.forName((String) entry.getValue(), true,
						Thread.currentThread().getContextClassLoader());
				providers.put(((String) entry.getKey()).toUpperCase(), (CharsetProvider) cla.newInstance());
			} catch (Throwable t) {
			}
		}
	}

}