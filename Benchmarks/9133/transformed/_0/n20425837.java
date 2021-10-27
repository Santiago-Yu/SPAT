class n20425837 {
	public static String loadSite(String EzqrIINp) throws IOException {
		URL PC3rojOA = new URL(EzqrIINp);
		BufferedReader Q3BNUjwM = new BufferedReader(new InputStreamReader(PC3rojOA.openStream()));
		String oabcUjSp = "";
		String G64JyrkJ;
		while ((G64JyrkJ = Q3BNUjwM.readLine()) != null) {
			oabcUjSp += G64JyrkJ + "\n";
		}
		Q3BNUjwM.close();
		return oabcUjSp;
	}

}