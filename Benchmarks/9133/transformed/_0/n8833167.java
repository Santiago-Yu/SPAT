class n8833167 {
	@SuppressWarnings("unchecked")
	private final D loadMeta(URL TAYAluX9) throws IOException {
		SAXParser Q3IHxQDC;
		try {
			Q3IHxQDC = SAX_PARSER_FACTORY.newSAXParser();
		} catch (ParserConfigurationException TfTcSeWP) {
			throw new Error(TfTcSeWP);
		} catch (SAXException SjawsbMN) {
			throw new Error(SjawsbMN);
		}
		try {
			Q3IHxQDC.setProperty("http://xml.org/sax/features/validation", false);
		} catch (SAXNotRecognizedException P3ouy35p) {
			P3ouy35p.printStackTrace();
		} catch (SAXNotSupportedException M2GQAgAv) {
			M2GQAgAv.printStackTrace();
		}
		MetaParser yvKrgnNW = new MetaParser();
		try {
			Q3IHxQDC.parse(TAYAluX9.openStream(), yvKrgnNW);
		} catch (SAXException KOvyVags) {
			throw new ParsingException(KOvyVags);
		}
		return ((D) yvKrgnNW.getMetaData());
	}

}