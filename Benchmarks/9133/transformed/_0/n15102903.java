class n15102903 {
	public static void translateTableAttributes(String O4Tzv7mp, String vG8WMNWO, NameSpaceDefinition MMHyY2Jc)
			throws Exception {
		setVosiNS(O4Tzv7mp, "table_att", MMHyY2Jc);
		String pDY3NJKO = O4Tzv7mp + "table_att.xsl";
		Scanner I0rIKdek = new Scanner(new File(pDY3NJKO));
		PrintWriter ZjpWZkGG = new PrintWriter(new File(O4Tzv7mp + vG8WMNWO + "_att.xsl"));
		while (I0rIKdek.hasNextLine()) {
			ZjpWZkGG.println(I0rIKdek.nextLine().replaceAll("TABLENAME", vG8WMNWO));
		}
		I0rIKdek.close();
		ZjpWZkGG.close();
		applyStyle(O4Tzv7mp + "tables.xml", O4Tzv7mp + vG8WMNWO + "_att.json", O4Tzv7mp + vG8WMNWO + "_att.xsl");
	}

}