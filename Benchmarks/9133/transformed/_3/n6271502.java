class n6271502 {
	@Override
	public InputStream getResourceByClassName(String className) {
		URL url = resourceFetcher.getResource("/fisce_scripts/" + className + ".class");
		if (!(url == null)) {
			try {
				return url.openStream();
			} catch (IOException e) {
				return null;
			}
		} else {
			return null;
		}
	}

}