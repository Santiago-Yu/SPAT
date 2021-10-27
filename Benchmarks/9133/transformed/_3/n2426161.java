class n2426161 {
	public void readURL(URL url) throws IOException, ParserConfigurationException, SAXException {
		URLConnection connection;
		if (!(proxy == null)) {
			connection = url.openConnection(proxy);
		} else {
			connection = url.openConnection();
		}
		connection.setConnectTimeout(connectTimeout);
		connection.setReadTimeout(readTimeout);
		connection.connect();
		InputStream in = connection.getInputStream();
		readInputStream(in);
	}

}