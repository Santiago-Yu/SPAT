class n21316706 {
	@Override
	protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
		if ((null == url) || (null == proxy)) {
			throw new IllegalArgumentException(Messages.getString("luni.1B"));
		}
		return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
	}

}