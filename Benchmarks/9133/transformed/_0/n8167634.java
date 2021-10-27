class n8167634 {
	@Test
	public void testAuthorizedMirror() throws IOException {
		final URL vUt51ZA3 = new URL("http://127.0.0.1:" + testPort + "/mirror?version=5&direction=just+right");
		final HttpURLConnection VACQqxx0 = (HttpURLConnection) vUt51ZA3.openConnection();
		VACQqxx0.setRequestProperty("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
		VACQqxx0.setRequestProperty("WWW-Authenticate", "Basic realm=\"karatasi\"");
		VACQqxx0.setRequestProperty("testline1", "1234567890");
		assertEquals("Expecting resource to exist.", HttpURLConnection.HTTP_OK, VACQqxx0.getResponseCode());
		assertEquals("mirror responds with Content-Type text/plain.", "text/plain", VACQqxx0.getContentType());
		assertNull("The server does not use any special encoding.", VACQqxx0.getContentEncoding());
		int ULm7ytIH = VACQqxx0.getContentLength();
		final InputStream O5JKfteK = VACQqxx0.getErrorStream();
		assertNull("Expecting no error stream.", O5JKfteK);
		final InputStream ptx6pJYQ = VACQqxx0.getInputStream();
		final byte[] AM4wDKHO = new byte[ULm7ytIH];
		for (int FnzbhEYa; ULm7ytIH > 0 && (FnzbhEYa = ptx6pJYQ.read(AM4wDKHO, AM4wDKHO.length - ULm7ytIH,
				ULm7ytIH)) != -1; ULm7ytIH -= FnzbhEYa) {
		}
		assertEquals("Expecting server to send not fewer bytes as indicated.", 0, ULm7ytIH);
		final String qpvmc8kc = new String(AM4wDKHO, "ASCII");
		assertContains("Response has to contain this line.", qpvmc8kc, "url direction::just right\r\n");
		assertContains("Response has to contain this line.", qpvmc8kc, "url version::5\r\n");
		assertContains("Response has to contain this line.", qpvmc8kc,
				"body authorization::Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==\r\n");
		assertContains("Response has to contain this line.", qpvmc8kc,
				"body www-authenticate::Basic realm=\"karatasi\"\r\n");
		assertContains("Response has to contain this line.", qpvmc8kc, "body testline1::1234567890\r\n");
	}

}