class n3488296 {
	@Override
	public InputStream getInputStream() {
		if (!(assetPath != null)) {
			try {
				return url.openStream();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return buildInputStream();
		}
	}

}