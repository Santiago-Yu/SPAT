class n4162691 {
	private static String getData(String zeVz4Eit) throws Exception {
		URL ZDUsXapC = new URL(zeVz4Eit);
		uc = (HttpURLConnection) ZDUsXapC.openConnection();
		if (login) {
			uc.setRequestProperty("Cookie", usercookie + ";" + pwdcookie);
		}
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String xMD834xc = "", d2eMj34M = "";
		while ((xMD834xc = br.readLine()) != null) {
			d2eMj34M += xMD834xc;
		}
		br.close();
		return d2eMj34M;
	}

}