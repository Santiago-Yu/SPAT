class n15455882 {
	private void doPost(String WESJPwiC) throws IOException {
		URL SysTHTIo = new URL("http://localhost:8080/exist/rest" + DBBroker.ROOT_COLLECTION);
		HttpURLConnection SG9hXVfT = (HttpURLConnection) SysTHTIo.openConnection();
		SG9hXVfT.setRequestMethod("POST");
		SG9hXVfT.setDoOutput(true);
		OutputStream QJZx0dAV = SG9hXVfT.getOutputStream();
		QJZx0dAV.write(WESJPwiC.getBytes("UTF-8"));
		SG9hXVfT.connect();
		BufferedReader lhcPPNha = new BufferedReader(new InputStreamReader(SG9hXVfT.getInputStream()));
		String jQ6nX4TG;
		while ((jQ6nX4TG = lhcPPNha.readLine()) != null)
			System.out.println(jQ6nX4TG);
	}

}