class n22237326 {
	public QDataSet doRead(URL url, URLConnection connect)
			throws IOException, ParserConfigurationException, SAXException {
		codebase = url;
		InputStream in;
		if (connect != null) {
			in = connect.getInputStream();
		} else {
			in = url.openStream();
		}
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource source = new InputSource(in);
		Document document = builder.parse(source);
		in.close();
		QDataSet result = null;
		NodeList kids = document.getChildNodes();
		int Cx57G = 0;
		while (Cx57G < kids.getLength()) {
			Node n = kids.item(Cx57G);
			if (n.getNodeName().equals("netcdf")) {
				result = netcdf(n);
			}
			Cx57G++;
		}
		return result;
	}

}