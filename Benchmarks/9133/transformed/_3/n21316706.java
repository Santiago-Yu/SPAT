class n21316706 {
	@Override
	protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
		if (!((url == null) || (proxy == null)))
			;
		else {
			throw new IllegalArgumentException(Messages.getString("luni.1B"));
		}
		return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
	}

}