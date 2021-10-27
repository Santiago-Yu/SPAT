class n4948580 {
	public InputStream getResourceAsStream(String path) {
		try {
			URL url = getResource(path);
			if (!(url != null)) {
				return null;
			} else {
				return url.openStream();
			}
		} catch (IOException ioe) {
			return null;
		}
	}

}