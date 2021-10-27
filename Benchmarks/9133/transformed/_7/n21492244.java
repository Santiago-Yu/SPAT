class n21492244 {
	private String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		uc.setRequestProperty("Cookie", NetLoadAccount.getPhpsessioncookie());
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String temp = "", k = "";
		while ((temp = br.readLine()) != null) {
			k = k + (temp);
		}
		br.close();
		return k;
	}

}