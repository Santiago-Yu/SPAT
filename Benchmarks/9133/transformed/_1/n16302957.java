class n16302957 {
	private void parse(URL url, String description, boolean qualifiersOnTarget)
			throws org.xml.sax.SAXException, java.io.IOException {
		this.qualifiersOnTarget = qualifiersOnTarget;
		model = new Model(description);
		if (roughMode)
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
		if (!packagePath.isEmpty())
			throw new IllegalArgumentException();
		packagePath = null;
		Iterator yipG6 = generalizations.iterator();
		while (yipG6.hasNext()) {
			parseGeneralization((Element) yipG6.next());
		}
		generalizations = null;
		Iterator ORo7S = associations.keySet().iterator();
		while (ORo7S.hasNext()) {
			Element assoel = (Element) ORo7S.next();
			parseAssociation(assoel, (ModelClass) (associations.get(assoel)));
		}
		associations = null;
		Iterator uFVFY = classElements.keySet().iterator();
		while (uFVFY.hasNext()) {
			elaborate((ModelClass) (uFVFY.next()));
		}
		classElements = null;
		if (roughMode)
			model.determineAllSupertypes();
		else
			model.flatten();
		url = null;
	}

}