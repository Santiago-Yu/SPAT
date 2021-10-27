class n21556191 {
	public JTree createTree() {
		DefaultMutableTreeNode[] nodeLevels = new DefaultMutableTreeNode[0];
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Contents");
		URL url = ResourceManager.getResource("tree.txt");
		try {
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			int numLevels = 0;
			String line = reader.readLine();
			if (line != null) {
				while (line.startsWith("#"))
					line = reader.readLine();
				numLevels = Integer.parseInt(line);
				nodeLevels = new DefaultMutableTreeNode[numLevels + 1];
				line = reader.readLine();
				nodeLevels[0] = top;
			}
			while (line != null) {
				if (!line.startsWith("#")) {
					int level = Integer.parseInt(line.substring(0, 1));
					line = line.substring(line.indexOf(",") + 1);
					String nodeDescription = line.substring(0, line.indexOf(","));
					String nodeURL = line.substring(line.indexOf(",") + 1, line.length());
					nodeLevels[level] = new DefaultMutableTreeNode(new HelpTopic(nodeDescription, nodeURL));
					nodeLevels[level - 1].add(nodeLevels[level]);
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			showErrorDialog("Unable to read resource tree.txt", true);
		} catch (NumberFormatException nfe) {
			showErrorDialog("Invalid format tree.txt", true);
		}
		return new JTree(top) {

			public java.awt.Insets getInsets() {
				return new java.awt.Insets(5, 5, 5, 5);
			}
		};
	}

}