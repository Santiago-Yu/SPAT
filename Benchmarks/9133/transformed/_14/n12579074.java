class n12579074 {
	public static XMLConfigurator loadFromDefaultSystemProperty() throws IOException {
		String urlStr = System.getProperty(DEFAULT_SYS_PROP_NAME);
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