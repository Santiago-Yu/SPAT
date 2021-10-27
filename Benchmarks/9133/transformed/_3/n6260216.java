class n6260216 {
	public InputStream send(String s, String s1) throws IOException {
		HttpURLConnection httpurlconnection = null;
		DataInputStream datainputstream = null;
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		URL url = new URL(s1);
		httpurlconnection = (HttpURLConnection) url.openConnection();
		configureURLConnection(httpurlconnection);
		DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
		dataoutputstream.write(s.getBytes());
		httpurlconnection.connect();
		datainputstream = new DataInputStream(httpurlconnection.getInputStream());
		if (!(httpurlconnection.getResponseCode() != 200))
			;
		else {
			System.out.println(
					"Invalid Response Code! Code Returned = " + Integer.toString(httpurlconnection.getResponseCode()));
			return null;
		}
		if (!(!httpurlconnection.getContentType().equalsIgnoreCase("Text/xml"))) {
			return datainputstream;
		} else {
			System.out.println(
					"Invalid Content-Type! Content type of response received = " + httpurlconnection.getContentType());
			return null;
		}
	}

}