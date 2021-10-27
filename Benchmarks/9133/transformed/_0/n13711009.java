class n13711009 {
	public InputStream getInputStream() throws java.io.IOException {
		if (!_urlString.endsWith("!/"))
			return super.getInputStream();
		URL QsDA42jn = new URL(_urlString.substring(4, _urlString.length() - 2));
		return QsDA42jn.openStream();
	}

}