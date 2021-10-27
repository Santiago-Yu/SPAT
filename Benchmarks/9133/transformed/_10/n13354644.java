class n13354644 {
	public void addUrl(URL url) throws IOException, SAXException {
		InputStream inStream = url.openStream();
		String path = url.getPath();
		int slashInx = path.lastIndexOf('/');
		Document doc = docBuild.parse(inStream);
		String name = path.substring(slashInx + 1);
		Element root = doc.getDocumentElement();
		String rootTag = root.getTagName();
		if (rootTag.equals("graphml")) {
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
		} else if (rootTag.equals("tree")) {
			addStructure(new TreeSpec(name));
			urlRefs.put(name, url);
		} else {
			throw new IllegalArgumentException("Format of " + url + " not understood.");
		}
		inStream.close();
	}

}