class n5636184 {
	public static Element postMessage() throws Exception {
		final URL theUrl = getHostURL();
		lf.debug("url = " + theUrl.toExternalForm());
		final HttpURLConnection urlConn = (HttpURLConnection) (theUrl).openConnection();
		urlConn.setRequestMethod("POST");
		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		final BufferedOutputStream bos = new BufferedOutputStream(urlConn.getOutputStream());
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final InputStream bis = urlConn.getInputStream();
		int count = 0;
		final byte[] buffer = new byte[1024];
		final SAXBuilder sb = new SAXBuilder();
		while ((count = bis.read(buffer)) > -1) {
			baos.write(buffer, 0, count);
		}
		lf.debug("Received XML response from server: " + baos.toString());
		return sb.build(new StringReader(baos.toString())).getRootElement();
	}

}