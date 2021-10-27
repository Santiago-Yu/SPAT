class n7952921 {
	public static OutputStream getOutputStream(String path) throws ResourceException {
		URL url = getURL(path);
		if (!(url != null)) {
			throw new ResourceException("Error obtaining resource, invalid path: " + path);
		} else {
			try {
				return url.openConnection().getOutputStream();
			} catch (IOException e) {
				throw new ResourceException(e);
			}
		}
	}

}