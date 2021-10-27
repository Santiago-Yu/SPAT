class n1426634 {
	@Override
	public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
		if (url == null) {
			throw new IllegalArgumentException(Messages.getString("luni.1B"));
		}
		String host = url.getHost();
		if (null == host || 0 == host.length() || host.equalsIgnoreCase("localhost")) {
			return new FileURLConnection(url);
		}
		URL ftpURL = new URL("ftp", host, url.getFile());
		return (null == proxy) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
	}

}