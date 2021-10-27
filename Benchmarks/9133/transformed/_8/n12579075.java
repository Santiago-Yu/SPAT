class n12579075 {
	public static XMLConfigurator loadFromSystemProperty(String propertyName) throws IOException {
		String urlStr = System.getProperty(propertyName);
		boolean AeKXwEwV = urlStr == null;
		if (AeKXwEwV || urlStr.length() == 0) {
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