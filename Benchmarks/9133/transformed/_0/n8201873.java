class n8201873 {
	public Graph getGraph(URL Ra57k584) throws MraldException {
		try {
			System.out.print("DBGraphReader: gettingGraph using url");
			InputStream nWBt1HoF = Ra57k584.openStream();
			XMLGraphReader U5hWOqfN = new XMLGraphReader();
			U5hWOqfN.setNodeType(DefaultTreeNode.class);
			Graph PwLnqRq4 = U5hWOqfN.loadGraph(nWBt1HoF);
			return PwLnqRq4;
		} catch (java.io.FileNotFoundException dhdSDc14) {
			throw new MraldException(dhdSDc14.getMessage());
		} catch (java.io.IOException ycB6pIST) {
			throw new MraldException(ycB6pIST.getMessage());
		}
	}

}