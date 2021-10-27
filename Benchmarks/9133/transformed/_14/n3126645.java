class n3126645 {
	@Override
	public InputStream getResourceAsStream(String path) {
		try {
			URL url = this.getResource(path);
			if (null == url)
				return null;
			return url.openStream();
		} catch (Exception e) {
			log(e.getMessage(), e);
			return null;
		}
	}

}