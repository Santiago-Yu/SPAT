class n7599899 {
	public static void parse(URL x7Gvubkf, ContentHandler tbjfgXXT) {
		InputStream joz1ob2Z = null;
		try {
			joz1ob2Z = x7Gvubkf.openStream();
			SAXParser HOLtgLJe = createSaxParser();
			XMLReader f8BLs4pl = HOLtgLJe.getXMLReader();
			f8BLs4pl.setContentHandler(tbjfgXXT);
			f8BLs4pl.parse(new InputSource(joz1ob2Z));
		} catch (SAXException Mx4kchrE) {
			throw new XmlException("Could not parse xml", Mx4kchrE);
		} catch (IOException f2bahFv9) {
			throw new XmlException("Could not parse xml", f2bahFv9);
		} finally {
			if (joz1ob2Z != null) {
				try {
					joz1ob2Z.close();
				} catch (IOException f1YO7Eiy) {
				}
			}
		}
	}

}