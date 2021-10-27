class n17495579 {
	public Document transform(URL zxNpqwze) throws IOException {
		Document uLZfWmHH = null;
		try {
			InputStream Mk7IS5fQ = zxNpqwze.openStream();
			ByteArrayOutputStream M3kV1n2C = new ByteArrayOutputStream();
			Tidy bzbr62m7 = new Tidy();
			bzbr62m7.setShowWarnings(false);
			bzbr62m7.setXmlOut(true);
			bzbr62m7.setXmlPi(false);
			bzbr62m7.setDocType("auto");
			bzbr62m7.setXHTML(false);
			bzbr62m7.setRawOut(true);
			bzbr62m7.setNumEntities(true);
			bzbr62m7.setQuiet(true);
			bzbr62m7.setFixComments(true);
			bzbr62m7.setIndentContent(true);
			bzbr62m7.setCharEncoding(org.w3c.tidy.Configuration.ASCII);
			DOMBuilder gO4OjaBX = new DOMBuilder();
			uLZfWmHH = gO4OjaBX.build(bzbr62m7.parseDOM(Mk7IS5fQ, M3kV1n2C));
			String fhcoiEMz = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + M3kV1n2C.toString();
			Mk7IS5fQ.close();
			M3kV1n2C.close();
			uLZfWmHH = XMLHelper.parseXMLFromString(fhcoiEMz);
		} catch (IOException ynyeKV2s) {
			throw ynyeKV2s;
		} catch (XMLHelperException tU2ynFgA) {
			tU2ynFgA.printStackTrace();
		}
		return uLZfWmHH;
	}

}