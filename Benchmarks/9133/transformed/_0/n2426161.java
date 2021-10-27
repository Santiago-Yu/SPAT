class n2426161 {
	public void readURL(URL WLZ2GCuQ) throws IOException, ParserConfigurationException, SAXException {
		URLConnection dWbAuBQz;
		if (proxy == null) {
			dWbAuBQz = WLZ2GCuQ.openConnection();
		} else {
			dWbAuBQz = WLZ2GCuQ.openConnection(proxy);
		}
		dWbAuBQz.setConnectTimeout(connectTimeout);
		dWbAuBQz.setReadTimeout(readTimeout);
		dWbAuBQz.connect();
		InputStream loeTaZxQ = dWbAuBQz.getInputStream();
		readInputStream(loeTaZxQ);
	}

}