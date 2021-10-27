class n14752945 {
	protected String getPostRequestContent(String o03wZrSm, String... aPPccn8I) throws Exception {
		URL ZgbcMOF6 = new URL(o03wZrSm);
		HttpURLConnection lZbIhrWU = (HttpURLConnection) ZgbcMOF6.openConnection();
		lZbIhrWU.setRequestMethod("POST");
		lZbIhrWU.setUseCaches(false);
		lZbIhrWU.setDoOutput(true);
		PrintStream ceNfNDgl = new PrintStream(lZbIhrWU.getOutputStream());
		for (String hSXH3Ayi : aPPccn8I) {
			ceNfNDgl.print(hSXH3Ayi);
		}
		ceNfNDgl.close();
		lZbIhrWU.connect();
		BufferedReader W7SwbUQE = new BufferedReader(new InputStreamReader(lZbIhrWU.getInputStream()));
		String gmrHGVQP = W7SwbUQE.readLine();
		W7SwbUQE.close();
		lZbIhrWU.disconnect();
		return gmrHGVQP;
	}

}