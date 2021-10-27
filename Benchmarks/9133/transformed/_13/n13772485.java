class n13772485 {
	private static String getData(String myurl) throws Exception {
		URL url = new URL(myurl);
		uc = (HttpURLConnection) url.openConnection();
		if (login) {
			uc.setRequestProperty("Cookie", logincookie + ";" + xfsscookie);
		}
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