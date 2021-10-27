class n5795551 {
	public static void main(String[] W20wOpt0) throws Exception {
		System.setProperty("debug", "debug");
		OAuthConsumer rXwhh9Dh = new DefaultOAuthConsumer("YmRF4HDvikvwDxYafsaK",
				"r)q7L!4X$j$nTS0lXAjC=al9Xf*cLOdyFJsy%2OE");
		rXwhh9Dh.setTokenWithSecret("5722da60fee79ef9efc2d383f871d550", "39142f31ad8a7e6ff7b87f36cc9e8f10");
		URL gF72mwYM = new URL("http://api.t.sohu.com/statuses/update.json");
		HttpURLConnection BQNMs2gm = (HttpURLConnection) gF72mwYM.openConnection();
		BQNMs2gm.setDoOutput(true);
		BQNMs2gm.setRequestMethod("POST");
		HttpParameters trEvUdR2 = new HttpParameters();
		trEvUdR2.put("status", URLEncoder.encode("中 文", "utf-8").replaceAll("\\+", "%20"));
		rXwhh9Dh.setAdditionalParameters(trEvUdR2);
		rXwhh9Dh.sign(BQNMs2gm);
		OutputStream DdyqitJ9 = BQNMs2gm.getOutputStream();
		DdyqitJ9.write(("status=" + URLEncoder.encode("1中 文", "utf-8")).replaceAll("\\+", "%20").getBytes());
		DdyqitJ9.flush();
		DdyqitJ9.close();
		System.out.println("Sending request...");
		BQNMs2gm.connect();
		System.out.println("Response: " + BQNMs2gm.getResponseCode() + " " + BQNMs2gm.getResponseMessage());
		BufferedReader e33yJI1r = new BufferedReader(new InputStreamReader(BQNMs2gm.getInputStream()));
		String YthZEOU1 = null;
		while ((YthZEOU1 = e33yJI1r.readLine()) != null) {
			System.out.println(YthZEOU1);
		}
	}

}