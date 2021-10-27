class n22237326 {
	public QDataSet doRead(URL url, URLConnection connect)
			throws IOException, ParserConfigurationException, SAXException {
		codebase = url;
		InputStream in;
		in = (connect != null) ? connect.getInputStream() : url.openStream();
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource source = new InputSource(in);
		Document document = builder.parse(source);
		in.close();
		QDataSet result = null;
		NodeList kids = document.getChildNodes();
		for (int i = 0; i < kids.getLength(); i++) {
			Node n = kids.item(i);
			result = (n.getNodeName().equals("netcdf")) ? netcdf(n) : result;
		}
		return result;
	}

}