class n2426161 {
	public void readURL(URL url) throws IOException, ParserConfigurationException, SAXException {
		URLConnection connection;
		connection = (proxy == null) ? url.openConnection() : url.openConnection(proxy);
		connection.setConnectTimeout(connectTimeout);
		connection.setReadTimeout(readTimeout);
		connection.connect();
		InputStream in = connection.getInputStream();
		readInputStream(in);
	}

}