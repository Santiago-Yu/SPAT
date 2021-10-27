class n5744992 {
	public void dorequest(Map<String, String> ps, String method) throws IOException {
		URL ourl = new URL(url);
		StringBuffer httpResponse = new StringBuffer();
		HttpURLConnection httpConnection = (HttpURLConnection) ourl.openConnection();
		httpConnection.setRequestMethod(method);
		httpConnection.setDoOutput(true);
		this.setCookie(httpConnection);
		StringBuffer postParams = new StringBuffer("");
		OutputStream httpOutputStream = httpConnection.getOutputStream();
		for (Entry<String, String> entry : ps.entrySet()) {
			postParams.append(entry.getKey());
			postParams.append("=");
			postParams.append(entry.getValue());
			postParams.append("&");
		}
		httpOutputStream.write(postParams.toString().getBytes());
		BufferedReader httpBufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		httpResponse.append(this.readBufferedContent(httpBufferedReader));
		text = httpResponse.toString();
		this.readCookie(httpConnection);
	}

}