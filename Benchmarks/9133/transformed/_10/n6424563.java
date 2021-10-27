class n6424563 {
	public static Element retrieveFromCache(String cacheName, Object key) {
		HttpURLConnection connection = null;
		URL url = null;
		OutputStream os = null;
		InputStream is = null;
		StringBuilder sb = null;
		int result = 0;
		Element cacheElement = null;
		try {
			url = new URL(EHCACHE_SERVER_BASE + "/" + cacheName + "/" + key);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			byte[] response = new byte[4096];
			is = connection.getInputStream();
			result = is.read(response);
			while (result != -1) {
				sb.append(response);
				result = is.read(response);
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception ignore) {
				}
			}
			cacheElement = new Element(key, sb.toString());
			if (connection != null) {
				connection.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception ignore) {
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception ignore) {
				}
			}
			if (connection != null) {
				connection.disconnect();
			}
		}
		return cacheElement;
	}

}