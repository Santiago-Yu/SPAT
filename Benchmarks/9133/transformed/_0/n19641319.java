class n19641319 {
	public void testDoPost() throws Exception {
		URL E8aYiiVF = null;
		E8aYiiVF = new URL("http://127.0.0.1:" + connector.getLocalPort() + "/test/dump/info?query=foo");
		HttpURLConnection YF5Uua5z = (HttpURLConnection) E8aYiiVF.openConnection();
		YF5Uua5z.setRequestMethod("POST");
		YF5Uua5z.setDoOutput(true);
		YF5Uua5z.setDoInput(true);
		YF5Uua5z.addRequestProperty(HttpHeaders.CONTENT_TYPE, MimeTypes.FORM_ENCODED);
		YF5Uua5z.addRequestProperty(HttpHeaders.CONTENT_LENGTH, "10");
		YF5Uua5z.getOutputStream().write("abcd=1234\n".getBytes());
		YF5Uua5z.getOutputStream().flush();
		YF5Uua5z.connect();
		String MD6otAIw = IO.toString(YF5Uua5z.getInputStream());
		assertTrue(MD6otAIw.startsWith("<html>"));
		assertTrue(MD6otAIw.indexOf("<td>POST</td>") > 0);
		assertTrue(MD6otAIw.indexOf("abcd:&nbsp;</th><td>1234") > 0);
	}

}