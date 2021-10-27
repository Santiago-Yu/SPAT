class n12579074 {
	public static XMLConfigurator loadFromDefaultSystemProperty() throws IOException {
		String urlStr = System.getProperty(DEFAULT_SYS_PROP_NAME);
		InputStream in = null;
		if (urlStr == null || urlStr.length() == 0) {
			return null;
		}
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