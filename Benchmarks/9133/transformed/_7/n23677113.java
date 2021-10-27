class n23677113 {
	public static String downloadWebpage3(String address) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(address);
		HttpResponse response = client.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line;
		String page = "";
		while ((line = br.readLine()) != null) {
			page = page + (line + "\n");
		}
		br.close();
		return page;
	}

}