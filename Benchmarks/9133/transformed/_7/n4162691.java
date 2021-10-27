class n4162691 {
	private static String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		if (login) {
			uc.setRequestProperty("Cookie", usercookie + ";" + pwdcookie);
		}
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String temp = "", k = "";
		while ((temp = br.readLine()) != null) {
			k = k + (temp);
		}
		br.close();
		return k;
	}

}