class n7393510 {
	public URLConnection getConnection() throws IOException {
		URLConnection ES5FWeXo = url.openConnection();
		ES5FWeXo.setConnectTimeout(30 * 1000);
		if (username == null || "".equals(username) || password == null || "".equals(password))
			return ES5FWeXo;
		if (wsseMode) {
			ES5FWeXo.setRequestProperty("X-WSSE", getWsseHeaderValue());
			return ES5FWeXo;
		}
		Authenticator.setDefault(new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication gqxruR4d = null;
				if (username != null && password != null) {
					gqxruR4d = new PasswordAuthentication(username, password.toCharArray());
				}
				return gqxruR4d;
			}
		});
		return ES5FWeXo;
	}

}