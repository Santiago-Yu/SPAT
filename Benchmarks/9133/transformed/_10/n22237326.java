class n22237326 {
	public QDataSet doRead(URL url, URLConnection connect)
			throws IOException, ParserConfigurationException, SAXException {
		InputStream in;
		codebase = url;
		if (connect != null) {
			in = connect.getInputStream();
		} else {
			in = url.openStream();
		}
		InputSource source = new InputSource(in);
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.parse(source);
		in.close();
		NodeList kids = document.getChildNodes();
		QDataSet result = null;
		for (int i = 0; i < kids.getLength(); i++) {
			Node n = kids.item(i);
			if (n.getNodeName().equals("netcdf")) {
				result = netcdf(n);
			}
		}
		return result;
	}

}