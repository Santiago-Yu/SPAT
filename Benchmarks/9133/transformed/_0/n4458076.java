class n4458076 {
	public InputStream getInputStream() throws TGBrowserException {
		try {
			if (!this.isFolder()) {
				URL l7a9jSmv = new URL(this.url);
				InputStream RnUru3Zl = l7a9jSmv.openStream();
				return RnUru3Zl;
			}
		} catch (Throwable KXo1LPIm) {
			throw new TGBrowserException(KXo1LPIm);
		}
		return null;
	}

}