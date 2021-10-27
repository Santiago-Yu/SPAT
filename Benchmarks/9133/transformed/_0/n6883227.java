class n6883227 {
	private HttpURLConnection getConnection(String qFOgKVdZ) throws IOException {
		HttpURLConnection zxvIKTdF = null;
		if (proxyHost != null && !proxyHost.equals("")) {
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
			final Proxy STXzzpWG = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(proxyHost, proxyPort));
			if (DEBUG) {
				log("Opening proxied connection(" + proxyHost + ":" + proxyPort + ")");
			}
			zxvIKTdF = (HttpURLConnection) new URL(qFOgKVdZ).openConnection(STXzzpWG);
		} else {
			zxvIKTdF = (HttpURLConnection) new URL(qFOgKVdZ).openConnection();
		}
		if (connectionTimeout > 0 && !isJDK14orEarlier) {
			zxvIKTdF.setConnectTimeout(connectionTimeout);
		}
		if (readTimeout > 0 && !isJDK14orEarlier) {
			zxvIKTdF.setReadTimeout(readTimeout);
		}
		return zxvIKTdF;
	}

}