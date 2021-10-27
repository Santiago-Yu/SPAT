class n19915605 {
	public static String Execute(HttpRequestBase httprequest) throws IOException, ClientProtocolException {
		httprequest.setHeader("Accept", "application/json");
		httprequest.setHeader("Content-type", "application/json");
		HttpClient httpclient = new DefaultHttpClient();
		String result = "";
		HttpResponse response = httpclient.execute(httprequest);
		String line = "";
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while ((line = rd.readLine()) != null) {
			result += line + "\n";
		}
		return result;
	}

}