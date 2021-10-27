class n21492244 {
	private String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		uc.setRequestProperty("Cookie", NetLoadAccount.getPhpsessioncookie());
		String temp = "", k = "";
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((temp = br.readLine()) != null) {
			k += temp;
		}
		br.close();
		return k;
	}

}