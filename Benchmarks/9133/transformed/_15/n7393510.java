class n7393510 {
	public URLConnection getConnection() throws IOException {
		URLConnection con = url.openConnection();
		con.setConnectTimeout(30 * 1000);
		if (username == null || (username != null && username.equals("")) || password == null
				|| (password != null && password.equals("")))
			return con;
		if (wsseMode) {
			con.setRequestProperty("X-WSSE", getWsseHeaderValue());
			return con;
		}
		Authenticator.setDefault(new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication auth = null;
				if (username != null && password != null) {
					auth = new PasswordAuthentication(username, password.toCharArray());
				}
				return auth;
			}
		});
		return con;
	}

}