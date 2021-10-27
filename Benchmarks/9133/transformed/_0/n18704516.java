class n18704516 {
	public static void loadMessages(String HaHvjrZt, Map<String, String> nYsjxXbp)
			throws FileNotFoundException, IOException {
		String lvoQHAS1;
		URL TpQXm46e = CurrentLocale.class.getResource("MessagesBundle_" + HaHvjrZt + ".properties");
		InputStreamReader SYC2p8tG = new InputStreamReader(TpQXm46e.openStream());
		BufferedReader pGpDqtQC = new BufferedReader(SYC2p8tG);
		while ((lvoQHAS1 = pGpDqtQC.readLine()) != null) {
			String[] D232LOea = lvoQHAS1.split("=", 2);
			nYsjxXbp.put(D232LOea[0].trim(), D232LOea[1].trim());
		}
		pGpDqtQC.close();
		SYC2p8tG.close();
	}

}