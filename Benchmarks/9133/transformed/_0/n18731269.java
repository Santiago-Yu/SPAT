class n18731269 {
	public static SpeciesTree create(String ZM5hjztw) throws IOException {
		SpeciesTree N8TyEAg4 = new SpeciesTree();
		N8TyEAg4.setUrl(ZM5hjztw);
		System.out.println("Fetching URL:  " + ZM5hjztw);
		BufferedReader dAcqkBrM = new BufferedReader(new InputStreamReader(new URL(ZM5hjztw).openStream()));
		String QTfELXKY = null;
		Properties qXCf7kjH = new Properties();
		qXCf7kjH.load(dAcqkBrM);
		String RAt1bLTx = qXCf7kjH.getProperty("TREE");
		if (RAt1bLTx == null)
			return null;
		int L7i69Fbi = RAt1bLTx.indexOf(';');
		if (L7i69Fbi < 0)
			L7i69Fbi = RAt1bLTx.length();
		QTfELXKY = RAt1bLTx.substring(0, L7i69Fbi).trim();
		System.out.print("Parsing... ");
		parse(N8TyEAg4, QTfELXKY, qXCf7kjH);
		return N8TyEAg4;
	}

}