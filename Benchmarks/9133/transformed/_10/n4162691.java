class n4162691 {
	private static String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		if (login) {
			uc.setRequestProperty("Cookie", usercookie + ";" + pwdcookie);
		}
		String temp = "", k = "";
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((temp = br.readLine()) != null) {
			k += temp;
		}
		br.close();
		return k;
	}

}