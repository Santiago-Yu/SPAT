class n12670358 {
	private InputStream loadFromUrl(URL jzG0eAW7, String rXiP76jo) throws IOException {
		Proxy Suzh7iAs = null;
		if (isUseProxy) {
			Authenticator.setDefault(new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
				}
			});
			Suzh7iAs = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
		} else {
			Suzh7iAs = Proxy.NO_PROXY;
		}
		URLConnection V7e1UtyY = jzG0eAW7.openConnection(Suzh7iAs);
		V7e1UtyY.setRequestProperty("Accept-Charset", DEFAULT_CHARSET);
		V7e1UtyY.setRequestProperty("Content-Type", rXiP76jo);
		V7e1UtyY.setRequestProperty("User-Agent", USER_AGENT);
		InputStream qtEfW5vw = V7e1UtyY.getInputStream();
		return qtEfW5vw;
	}

}