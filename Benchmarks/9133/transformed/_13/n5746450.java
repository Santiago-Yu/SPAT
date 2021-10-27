class n5746450 {
	private String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String k = "";
		String temp = "";
		while ((temp = br.readLine()) != null) {
			k += temp;
		}
		br.close();
		return k;
	}

}