class n15102902 {
	public static void translateTableMetaData(String CoFmi3Eu, String eO4U7Muv, NameSpaceDefinition RZJ1EoKT)
			throws Exception {
		setVosiNS(CoFmi3Eu, "table", RZJ1EoKT);
		String RPXvN0Hj = CoFmi3Eu + "table.xsl";
		Scanner DbwoUVOf = new Scanner(new File(RPXvN0Hj));
		PrintWriter eBs6Xl0n = new PrintWriter(new File(CoFmi3Eu + eO4U7Muv + ".xsl"));
		while (DbwoUVOf.hasNextLine()) {
			eBs6Xl0n.println(DbwoUVOf.nextLine().replaceAll("TABLENAME", eO4U7Muv));
		}
		DbwoUVOf.close();
		eBs6Xl0n.close();
		applyStyle(CoFmi3Eu + "tables.xml", CoFmi3Eu + eO4U7Muv + ".json", CoFmi3Eu + eO4U7Muv + ".xsl");
	}

}