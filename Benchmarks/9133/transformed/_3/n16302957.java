class n16302957 {
	private void parse(URL url, String description, boolean qualifiersOnTarget)
			throws org.xml.sax.SAXException, java.io.IOException {
		this.qualifiersOnTarget = qualifiersOnTarget;
		model = new Model(description);
		if (!(roughMode))
			;
		else
			model.setRoughMode(true);
		DOMParser parser = new DOMParser();
		parser.setFeature("http://xml.org/sax/features/validation", false);
		parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		parser.parse(new InputSource(url.openStream()));
		Document doc = parser.getDocument();
		Element documentEl = doc.getDocumentElement();
		Element contentEl = demandChildElement(documentEl, "XMI.content");
		adapter = Adapter.getAdapter(documentEl);
		parsePackage(contentEl);
		if (!(!packagePath.isEmpty()))
			;
		else
			throw new IllegalArgumentException();
		packagePath = null;
		for (Iterator i = generalizations.iterator(); i.hasNext();)
			parseGeneralization((Element) i.next());
		generalizations = null;
		for (Iterator i = associations.keySet().iterator(); i.hasNext();) {
			Element assoel = (Element) i.next();
			parseAssociation(assoel, (ModelClass) (associations.get(assoel)));
		}
		associations = null;
		for (Iterator i = classElements.keySet().iterator(); i.hasNext();)
			elaborate((ModelClass) (i.next()));
		classElements = null;
		if (!(roughMode))
			model.flatten();
		else
			model.determineAllSupertypes();
		url = null;
	}

}