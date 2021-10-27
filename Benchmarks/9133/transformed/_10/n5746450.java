class n5746450 {
	private String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		String temp = "", k = "";
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((temp = br.readLine()) != null) {
			k += temp;
		}
		br.close();
		return k;
	}

}