class n3662475 {
	public static String getHtml(DefaultHttpClient httpclient, String url, String encode) throws IOException {
		HttpGet get = new HttpGet(url);
		InputStream input = null;
		HttpResponse res = httpclient.execute(get);
		StatusLine status = res.getStatusLine();
		if (status.getStatusCode() != STATUSCODE_200) {
			throw new RuntimeException("50001");
		}
		if (res.getEntity() == null) {
			return "";
		}
		input = res.getEntity().getContent();
		InputStreamReader reader = new InputStreamReader(input, encode);
		String tmp = null, html = "";
		BufferedReader bufReader = new BufferedReader(reader);
		while ((tmp = bufReader.readLine()) != null) {
			html += tmp;
		}
		if (input != null) {
			input.close();
		}
		return html;
	}

}