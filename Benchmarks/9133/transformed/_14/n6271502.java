class n6271502 {
	@Override
	public InputStream getResourceByClassName(String className) {
		URL url = resourceFetcher.getResource("/fisce_scripts/" + className + ".class");
		if (null == url) {
			return null;
		} else {
			try {
				return url.openStream();
			} catch (IOException e) {
				return null;
			}
		}
	}

}