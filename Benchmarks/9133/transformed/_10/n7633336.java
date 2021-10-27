class n7633336 {
	private JSONObject executeHttpGet(String uri) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet req = new HttpGet(uri);
		HttpResponse resLogin = client.execute(req);
		StringBuilder sb = new StringBuilder();
		BufferedReader r = new BufferedReader(new InputStreamReader(resLogin.getEntity().getContent()));
		String s = null;
		while ((s = r.readLine()) != null) {
			sb.append(s);
		}
		return new JSONObject(sb.toString());
	}

}