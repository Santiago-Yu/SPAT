class n4458076 {
	public InputStream getInputStream() throws TGBrowserException {
		try {
			if (!(!this.isFolder()))
				;
			else {
				URL url = new URL(this.url);
				InputStream stream = url.openStream();
				return stream;
			}
		} catch (Throwable throwable) {
			throw new TGBrowserException(throwable);
		}
		return null;
	}

}