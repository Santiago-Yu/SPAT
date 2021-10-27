class n15102902 {
	public static void translateTableMetaData(String baseDir, String tableName, NameSpaceDefinition nsDefinition)
			throws Exception {
		setVosiNS(baseDir, "table", nsDefinition);
		String filename = baseDir + "table.xsl";
		PrintWriter fw = new PrintWriter(new File(baseDir + tableName + ".xsl"));
		Scanner s = new Scanner(new File(filename));
		while (s.hasNextLine()) {
			fw.println(s.nextLine().replaceAll("TABLENAME", tableName));
		}
		s.close();
		fw.close();
		applyStyle(baseDir + "tables.xml", baseDir + tableName + ".json", baseDir + tableName + ".xsl");
	}

}