class n18731269 {
	public static SpeciesTree create(String url) throws IOException {
		SpeciesTree tree = new SpeciesTree();
		tree.setUrl(url);
		System.out.println("Fetching URL:  " + url);
		String toParse = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
		Properties properties = new Properties();
		properties.load(in);
		String line = properties.getProperty("TREE");
		if (line == null)
			return null;
		int end = line.indexOf(';');
		if (end < 0)
			end = line.length();
		toParse = line.substring(0, end).trim();
		System.out.print("Parsing... ");
		parse(tree, toParse, properties);
		return tree;
	}

}