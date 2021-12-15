class n13354644 {
	public void addUrl(URL url) throws IOException, SAXException {
		InputStream inStream = url.openStream();
		String path = url.getPath();
		int slashInx = path.lastIndexOf('/');
		String name = path.substring(slashInx + 1);
		Document doc = docBuild.parse(inStream);
		Element root = doc.getDocumentElement();
		String rootTag = root.getTagName();
		if ("graphml".equals(rootTag)) {
			NodeList graphNodes = root.getElementsByTagName("graph");
			for (int i = 0; i < graphNodes.getLength(); i++) {
				Element elem = (Element) graphNodes.item(i);
				String graphName = elem.getAttribute("id");
				if (graphName == null) {
					graphName = name;
				}
				addStructure(new GraphSpec(graphName));
				urlRefs.put(graphName, url);
			}
		} else if ("tree".equals(rootTag)) {
			addStructure(new TreeSpec(name));
			urlRefs.put(name, url);
		} else {
			throw new IllegalArgumentException("Format of " + url + " not understood.");
		}
		inStream.close();
	}

}