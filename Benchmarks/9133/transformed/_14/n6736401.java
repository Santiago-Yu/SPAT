class n6736401 {
	public InputStream getResourceAsStream(String path) {
		try {
			URL url = getResource(path);
			if (null == url)
				return null;
			return url.openStream();
		} catch (Exception e) {
			Log.ignore(e);
			return null;
		}
	}

}