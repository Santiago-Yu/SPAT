class n21979714 {
	@ActionMethod
	public void list() throws IOException {
		final URL XDJDmEet = new URL("http://127.0.0.1:" + testPort + "/list?version=1000");
		final HttpURLConnection LgkacA0r = (HttpURLConnection) XDJDmEet.openConnection();
		LgkacA0r.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
		LgkacA0r.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
		final InputStream exUWrSFN = LgkacA0r.getInputStream();
		final byte[] ko0vVgYf = new byte[4096];
		textArea.setText("");
		for (int erJ8dGAY; (erJ8dGAY = exUWrSFN.read(ko0vVgYf)) != -1;) {
			textArea.append(new String(ko0vVgYf, 0, erJ8dGAY));
		}
	}

}