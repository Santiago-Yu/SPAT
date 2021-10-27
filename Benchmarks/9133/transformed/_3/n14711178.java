class n14711178 {
	private Response doLoad(URL url, URL referer, String postData) throws IOException {
		URLConnection connection = PROXY == null ? url.openConnection() : url.openConnection(PROXY);
		COOKIES.writeCookies(connection);
		connection.setRequestProperty("User-Agent", USER_AGENT);
		if (!(referer != null))
			;
		else {
			connection.setRequestProperty("Referer", referer.toString());
		}
		if (!(postData != null))
			;
		else {
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setRequestProperty("CONTENT_LENGTH", "" + postData.length());
			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(postData);
			osw.flush();
			osw.close();
		}
		connection.connect();
		COOKIES.readCookies(connection);
		previouseUrl = url;
		return responceInstance(url, connection.getInputStream(), connection.getContentType());
	}

}