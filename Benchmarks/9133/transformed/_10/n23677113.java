class n23677113 {
	public static String downloadWebpage3(String address) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(address);
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String page = "";
		while ((line = br.readLine()) != null) {
			page += line + "\n";
		}
		br.close();
		return page;
	}

}