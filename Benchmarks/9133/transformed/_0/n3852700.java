class n3852700 {
	public URLConnection getResourceConnection(String UGDkgJwT) throws ResourceException {
		if (context == null)
			throw new ResourceException("There is no ServletContext to get the requested resource");
		URL VrPxuT8r = null;
		try {
			VrPxuT8r = context.getResource("/WEB-INF/scriptags/" + UGDkgJwT);
			return VrPxuT8r.openConnection();
		} catch (Exception PkOZqpEc) {
			throw new ResourceException(String.format("Resource '%s' could not be found (url: %s)", UGDkgJwT, VrPxuT8r),
					PkOZqpEc);
		}
	}

}