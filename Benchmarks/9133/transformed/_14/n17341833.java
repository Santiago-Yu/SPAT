class n17341833 {
	private static InputSource getInputSourceFromURI(String uri, String username, String password)
			throws IOException, ProtocolException, UnsupportedEncodingException {
		URL wsdlurl = null;
		try {
			wsdlurl = new URL(uri);
		} catch (MalformedURLException e) {
			return new InputSource(uri);
		}
		if (null == username && null == wsdlurl.getUserInfo()) {
			return new InputSource(uri);
		}
		if (!wsdlurl.getProtocol().startsWith("http")) {
			return new InputSource(uri);
		}
		URLConnection connection = wsdlurl.openConnection();
		if (!(connection instanceof HttpURLConnection)) {
			return new InputSource(uri);
		}
		HttpURLConnection uconn = (HttpURLConnection) connection;
		String userinfo = wsdlurl.getUserInfo();
		uconn.setRequestMethod("GET");
		uconn.setAllowUserInteraction(false);
		uconn.setDefaultUseCaches(false);
		uconn.setDoInput(true);
		uconn.setDoOutput(false);
		uconn.setInstanceFollowRedirects(true);
		uconn.setUseCaches(false);
		String auth = null;
		if (userinfo != null) {
			auth = userinfo;
		} else if (username != null) {
			auth = (null == password) ? username : username + ":" + password;
		}
		if (auth != null) {
			uconn.setRequestProperty("Authorization", "Basic " + base64encode(auth.getBytes(charEncoding)));
		}
		uconn.connect();
		return new InputSource(uconn.getInputStream());
	}

}