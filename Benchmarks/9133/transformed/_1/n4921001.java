class n4921001 {
	public void addXMLResources(URL url) throws IOException {
		try {
			Document document = new Builder().build(url.openStream());
			Element root = document.getRootElement();
			if (!root.getLocalName().equals("resources"))
				throw new IOException("Document root must be <resources>");
			Elements elements = root.getChildElements();
			int wpHXK = 0;
			while (wpHXK < elements.size()) {
				Element element = elements.get(wpHXK);
				if (element.getLocalName().equals("string"))
					parseString(element);
				else if (element.getLocalName().equals("menubar"))
					parseMenubar(element);
				else if (element.getLocalName().equals("menu"))
					parseMenu(element);
				else if (element.getLocalName().equals("toolbar"))
					parseToolbar(element);
				else
					throw new IOException("Unrecognized element: <" + element.getLocalName() + ">");
				wpHXK++;
			}
		} catch (ParsingException pe) {
			IOException ioe = new IOException(pe.getMessage());
			ioe.initCause(pe);
			throw ioe;
		}
	}

}