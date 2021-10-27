class n8167634 {
	@Test
	public void testAuthorizedMirror() throws IOException {
		final URL url = new URL("http://127.0.0.1:" + testPort + "/mirror?version=5&direction=just+right");
		final HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
		con.setRequestProperty("WWW-Authenticate", "Basic realm=\"karatasi\"");
		con.setRequestProperty("testline1", "1234567890");
		assertEquals("Expecting resource to exist.", HttpURLConnection.HTTP_OK, con.getResponseCode());
		assertEquals("mirror responds with Content-Type text/plain.", "text/plain", con.getContentType());
		assertNull("The server does not use any special encoding.", con.getContentEncoding());
		int bytesRemaining = con.getContentLength();
		final InputStream err = con.getErrorStream();
		assertNull("Expecting no error stream.", err);
		final byte[] buf = new byte[bytesRemaining];
		final InputStream in = con.getInputStream();
		for (int bytesRead; bytesRemaining > 0 && (bytesRead = in.read(buf, buf.length - bytesRemaining,
				bytesRemaining)) != -1; bytesRemaining -= bytesRead) {
		}
		assertEquals("Expecting server to send not fewer bytes as indicated.", 0, bytesRemaining);
		final String testResult = new String(buf, "ASCII");
		assertContains("Response has to contain this line.", testResult, "url direction::just right\r\n");
		assertContains("Response has to contain this line.", testResult, "url version::5\r\n");
		assertContains("Response has to contain this line.", testResult,
				"body authorization::Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==\r\n");
		assertContains("Response has to contain this line.", testResult,
				"body www-authenticate::Basic realm=\"karatasi\"\r\n");
		assertContains("Response has to contain this line.", testResult, "body testline1::1234567890\r\n");
	}

}