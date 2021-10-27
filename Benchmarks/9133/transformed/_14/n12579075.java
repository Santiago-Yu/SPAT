class n12579075 {
	public static XMLConfigurator loadFromSystemProperty(String propertyName) throws IOException {
		String urlStr = System.getProperty(propertyName);
		if (null == urlStr || 0 == urlStr.length()) {
			return null;
		}
		InputStream in = null;
		DOMRetriever xmlDoc = null;
		try {
			URL url = new URL(urlStr);
			xmlDoc = new DOMRetriever(in = url.openStream());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} finally {
			if (in != null)
				in.close();
		}
		return newInstance(xmlDoc);
	}

}