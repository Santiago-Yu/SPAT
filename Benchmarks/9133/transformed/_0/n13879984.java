class n13879984 {
	public static String readFromURL(String S5AR8unY) throws IOException {
		URL CONYck9p = new URL(S5AR8unY);
		StringBuilder Y0Mjy7fB = new StringBuilder();
		BufferedReader Xp13YSew = new BufferedReader(new InputStreamReader(CONYck9p.openStream()));
		String O29Zm8EG;
		while ((O29Zm8EG = Xp13YSew.readLine()) != null) {
			Y0Mjy7fB.append(O29Zm8EG);
		}
		Xp13YSew.close();
		return Y0Mjy7fB.toString();
	}

}