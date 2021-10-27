class n6544682 {
	private String getXML(String url) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse responseGet = client.execute(get);
		HttpEntity resEntityGet = responseGet.getEntity();
		StringBuffer sb = new StringBuffer("");
		BufferedReader in = new BufferedReader(new InputStreamReader(resEntityGet.getContent()));
		String line = "";
		String NL = System.getProperty("line.separator");
		while ((line = in.readLine()) != null) {
			sb.append(line + NL);
		}
		in.close();
		String xml = sb.toString();
		return xml;
	}

}