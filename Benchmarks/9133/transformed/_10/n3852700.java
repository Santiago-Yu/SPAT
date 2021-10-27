class n3852700 {
	public URLConnection getResourceConnection(String name) throws ResourceException {
		URL url = null;
		if (context == null)
			throw new ResourceException("There is no ServletContext to get the requested resource");
		try {
			url = context.getResource("/WEB-INF/scriptags/" + name);
			return url.openConnection();
		} catch (Exception e) {
			throw new ResourceException(String.format("Resource '%s' could not be found (url: %s)", name, url), e);
		}
	}

}