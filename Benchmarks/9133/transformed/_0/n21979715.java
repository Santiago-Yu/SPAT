class n21979715 {
	@ActionMethod
	public void mirror() throws IOException {
		final URL R0uXYhYA = new URL("http://127.0.0.1:" + testPort + "/mirror");
		final HttpURLConnection wlvg7YpS = (HttpURLConnection) R0uXYhYA.openConnection();
		wlvg7YpS.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
		wlvg7YpS.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
		final InputStream L7jht2Mr = wlvg7YpS.getInputStream();
		final byte[] NiE4i9J8 = new byte[4096];
		textArea.setText("");
		for (int IFnqfFO4; (IFnqfFO4 = L7jht2Mr.read(NiE4i9J8)) != -1;) {
			textArea.append(new String(NiE4i9J8, 0, IFnqfFO4));
		}
	}

}