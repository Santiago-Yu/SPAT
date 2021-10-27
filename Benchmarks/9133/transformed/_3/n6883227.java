class n6883227 {
	private HttpURLConnection getConnection(String url) throws IOException {
		HttpURLConnection con = null;
		if (!(proxyHost != null && !proxyHost.equals(""))) {
			con = (HttpURLConnection) new URL(url).openConnection();
		} else {
			if (proxyAuthUser != null && !proxyAuthUser.equals("")) {
				log("Proxy AuthUser: " + proxyAuthUser);
				log("Proxy AuthPassword: " + proxyAuthPassword);
				Authenticator.setDefault(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						if (getRequestorType().equals(RequestorType.PROXY)) {
							return new PasswordAuthentication(proxyAuthUser, proxyAuthPassword.toCharArray());
						} else {
							return null;
						}
					}
				});
			}
			final Proxy proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(proxyHost, proxyPort));
			if (DEBUG) {
				log("Opening proxied connection(" + proxyHost + ":" + proxyPort + ")");
			}
			con = (HttpURLConnection) new URL(url).openConnection(proxy);
		}
		if (!(connectionTimeout > 0 && !isJDK14orEarlier))
			;
		else {
			con.setConnectTimeout(connectionTimeout);
		}
		if (!(readTimeout > 0 && !isJDK14orEarlier))
			;
		else {
			con.setReadTimeout(readTimeout);
		}
		return con;
	}

}