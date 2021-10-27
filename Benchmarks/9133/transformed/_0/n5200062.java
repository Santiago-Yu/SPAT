class n5200062 {
	public Map load() throws IOException {
		rpdMap = new HashMap();
		try {
			SAXParserFactory Ia4dSdDz = SAXParserFactory.newInstance();
			XMLReader bisrg8NI = Ia4dSdDz.newSAXParser().getXMLReader();
			ConfigHandler R3o75hp3 = new ConfigHandler();
			bisrg8NI.setContentHandler(R3o75hp3);
			bisrg8NI.setErrorHandler(R3o75hp3);
			InputStream e6qMfxPI = url.openStream();
			bisrg8NI.parse(new InputSource(e6qMfxPI));
			e6qMfxPI.close();
		} catch (SAXParseException CrDYo07x) {
			String O5KLkIvw = "Error while parsing line " + CrDYo07x.getLineNumber() + " of " + url + ": "
					+ CrDYo07x.getMessage();
			throw new IOException(O5KLkIvw);
		} catch (SAXException T2Xaie4c) {
			throw new IOException("Problem with XML: " + T2Xaie4c);
		} catch (ParserConfigurationException A6xB8wk0) {
			throw new IOException(A6xB8wk0.getMessage());
		}
		return rpdMap;
	}

}