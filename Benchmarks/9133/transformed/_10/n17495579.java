class n17495579 {
	public Document transform(URL url) throws IOException {
		Document doc = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream in = url.openStream();
			Tidy tidy = new Tidy();
			tidy.setShowWarnings(false);
			tidy.setXmlOut(true);
			tidy.setXmlPi(false);
			tidy.setDocType("auto");
			tidy.setXHTML(false);
			tidy.setRawOut(true);
			tidy.setNumEntities(true);
			tidy.setQuiet(true);
			tidy.setFixComments(true);
			tidy.setIndentContent(true);
			tidy.setCharEncoding(org.w3c.tidy.Configuration.ASCII);
			DOMBuilder docBuilder = new DOMBuilder();
			doc = docBuilder.build(tidy.parseDOM(in, baos));
			String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + baos.toString();
			in.close();
			baos.close();
			doc = XMLHelper.parseXMLFromString(result);
		} catch (IOException ioEx) {
			throw ioEx;
		} catch (XMLHelperException xmlEx) {
			xmlEx.printStackTrace();
		}
		return doc;
	}

}