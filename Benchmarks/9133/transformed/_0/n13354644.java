class n13354644 {
	public void addUrl(URL RlYjQPwK) throws IOException, SAXException {
		InputStream A199F3JK = RlYjQPwK.openStream();
		String Vr76kgXH = RlYjQPwK.getPath();
		int uXATzrII = Vr76kgXH.lastIndexOf('/');
		String WCzwUbZL = Vr76kgXH.substring(uXATzrII + 1);
		Document OwpIFRWA = docBuild.parse(A199F3JK);
		Element DMpwqdgF = OwpIFRWA.getDocumentElement();
		String hYtGRVdc = DMpwqdgF.getTagName();
		if (hYtGRVdc.equals("graphml")) {
			NodeList DeXy7mcY = DMpwqdgF.getElementsByTagName("graph");
			for (int qEtuBUuN = 0; qEtuBUuN < DeXy7mcY.getLength(); qEtuBUuN++) {
				Element RUD2dSXK = (Element) DeXy7mcY.item(qEtuBUuN);
				String Cj31oXUg = RUD2dSXK.getAttribute("id");
				if (Cj31oXUg == null) {
					Cj31oXUg = WCzwUbZL;
				}
				addStructure(new GraphSpec(Cj31oXUg));
				urlRefs.put(Cj31oXUg, RlYjQPwK);
			}
		} else if (hYtGRVdc.equals("tree")) {
			addStructure(new TreeSpec(WCzwUbZL));
			urlRefs.put(WCzwUbZL, RlYjQPwK);
		} else {
			throw new IllegalArgumentException("Format of " + RlYjQPwK + " not understood.");
		}
		A199F3JK.close();
	}

}