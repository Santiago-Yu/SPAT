class n3594612 {
	public static String[] check() throws Exception {
		if (currentVersion == null)
			throw new Exception();
		URL fZn7ns7J = new URL(versionURL);
		HttpURLConnection U5YxC0Gw = (HttpURLConnection) fZn7ns7J.openConnection();
		String JndSAKv1 = "";
		BufferedReader RnM9b9sm = new BufferedReader(new InputStreamReader(U5YxC0Gw.getInputStream()));
		while (RnM9b9sm.ready()) {
			JndSAKv1 = JndSAKv1 + RnM9b9sm.readLine();
		}
		RnM9b9sm.close();
		Document fAZ8MsgA = DocumentHelper.parseText(JndSAKv1);
		Node xz3zOANs = fAZ8MsgA.selectSingleNode("//root/version");
		String VZtTD1CU = xz3zOANs.valueOf("@id");
		Double P6wNI4Ij = Double.parseDouble(VZtTD1CU);
		Double MDs3dKzo = Double.parseDouble(currentVersion.substring(0, currentVersion.indexOf("-")));
		if (P6wNI4Ij > MDs3dKzo) {
			String[] lygBv52g = { VZtTD1CU, xz3zOANs.valueOf("@url"), xz3zOANs.valueOf("@description") };
			return lygBv52g;
		}
		return null;
	}

}