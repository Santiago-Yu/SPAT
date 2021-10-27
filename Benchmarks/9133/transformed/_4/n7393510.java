class n7393510 {
	public URLConnection getConnection() throws IOException {
		URLConnection con = url.openConnection();
		con.setConnectTimeout(30 * 1000);
		if (username == null || "".equals(username) || password == null || "".equals(password))
			return con;
		if (wsseMode) {
			con.setRequestProperty("X-WSSE", getWsseHeaderValue());
			return con;
		}
		Authenticator.setDefault(new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication auth = null;
				auth = (username != null && password != null)
						? new PasswordAuthentication(username, password.toCharArray())
						: auth;
				return auth;
			}
		});
		return con;
	}

}