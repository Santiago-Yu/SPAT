class n8201873 {
	public Graph getGraph(URL urlFilename) throws MraldException {
		try {
			System.out.print("DBGraphReader: gettingGraph using url");
			XMLGraphReader gr = new XMLGraphReader();
			InputStream inUrl = urlFilename.openStream();
			gr.setNodeType(DefaultTreeNode.class);
			Graph graph = gr.loadGraph(inUrl);
			return graph;
		} catch (java.io.FileNotFoundException e) {
			throw new MraldException(e.getMessage());
		} catch (java.io.IOException e) {
			throw new MraldException(e.getMessage());
		}
	}

}