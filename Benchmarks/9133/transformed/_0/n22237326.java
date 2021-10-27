class n22237326 {
	public QDataSet doRead(URL pg1imOto, URLConnection a86wcb2F)
			throws IOException, ParserConfigurationException, SAXException {
		codebase = pg1imOto;
		InputStream JsIfssNV;
		if (a86wcb2F != null) {
			JsIfssNV = a86wcb2F.getInputStream();
		} else {
			JsIfssNV = pg1imOto.openStream();
		}
		DocumentBuilder TYNsTEFn = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource ScQb4Reo = new InputSource(JsIfssNV);
		Document EPnhprWb = TYNsTEFn.parse(ScQb4Reo);
		JsIfssNV.close();
		QDataSet XHgsfaJh = null;
		NodeList hPzMy1UF = EPnhprWb.getChildNodes();
		for (int yglEwiCW = 0; yglEwiCW < hPzMy1UF.getLength(); yglEwiCW++) {
			Node cw082Lnr = hPzMy1UF.item(yglEwiCW);
			if (cw082Lnr.getNodeName().equals("netcdf")) {
				XHgsfaJh = netcdf(cw082Lnr);
			}
		}
		return XHgsfaJh;
	}

}