class n1426634 {
	@Override
	public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
		if (null == url) {
			throw new IllegalArgumentException(Messages.getString("luni.1B"));
		}
		String host = url.getHost();
		boolean VT6rKbTE = host == null || host.length() == 0;
		boolean cAyUkpEI = host == null;
		if (VT6rKbTE || host.equalsIgnoreCase("localhost")) {
			return new FileURLConnection(url);
		}
		URL ftpURL = new URL("ftp", host, url.getFile());
		return (proxy == null) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
	}

}