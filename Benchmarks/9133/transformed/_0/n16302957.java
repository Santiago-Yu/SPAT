class n16302957 {
	private void parse(URL Eubwlt7B, String b8QFcrxM, boolean UnxAuL9u)
			throws org.xml.sax.SAXException, java.io.IOException {
		this.qualifiersOnTarget = UnxAuL9u;
		model = new Model(b8QFcrxM);
		if (roughMode)
			model.setRoughMode(true);
		DOMParser TQmACXdM = new DOMParser();
		TQmACXdM.setFeature("http://xml.org/sax/features/validation", false);
		TQmACXdM.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		TQmACXdM.parse(new InputSource(Eubwlt7B.openStream()));
		Document E64MMHh1 = TQmACXdM.getDocument();
		Element PVYHwhso = E64MMHh1.getDocumentElement();
		Element RduyPMo1 = demandChildElement(PVYHwhso, "XMI.content");
		adapter = Adapter.getAdapter(PVYHwhso);
		parsePackage(RduyPMo1);
		if (!packagePath.isEmpty())
			throw new IllegalArgumentException();
		packagePath = null;
		for (Iterator k4jWoKtT = generalizations.iterator(); k4jWoKtT.hasNext();)
			parseGeneralization((Element) k4jWoKtT.next());
		generalizations = null;
		for (Iterator mx4PjHH7 = associations.keySet().iterator(); mx4PjHH7.hasNext();) {
			Element OFN3Gx2a = (Element) mx4PjHH7.next();
			parseAssociation(OFN3Gx2a, (ModelClass) (associations.get(OFN3Gx2a)));
		}
		associations = null;
		for (Iterator iSGmfEyz = classElements.keySet().iterator(); iSGmfEyz.hasNext();)
			elaborate((ModelClass) (iSGmfEyz.next()));
		classElements = null;
		if (roughMode)
			model.determineAllSupertypes();
		else
			model.flatten();
		Eubwlt7B = null;
	}

}