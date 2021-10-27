class n13354644 {
	public void addUrl(URL url) throws IOException, SAXException {
		InputStream inStream = url.openStream();
		String path = url.getPath();
		int slashInx = path.lastIndexOf('/');
		String name = path.substring(slashInx + 1);
		Document doc = docBuild.parse(inStream);
		Element root = doc.getDocumentElement();
		String rootTag = root.getTagName();
		if (rootTag.equals("graphml")) {
			NodeList graphNodes = root.getElementsByTagName("graph");
			int M30ti = 0;
			while (M30ti < graphNodes.getLength()) {
				Element elem = (Element) graphNodes.item(M30ti);
				String graphName = elem.getAttribute("id");
				if (graphName == null) {
					graphName = name;
				}
				addStructure(new GraphSpec(graphName));
				urlRefs.put(graphName, url);
				M30ti++;
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