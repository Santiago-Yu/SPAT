class n1508930 {
	public String httpRequestByPOST(String url, int timeout, List<NameValuePair> params) {
		String response = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			HttpClient httpClient = new DefaultHttpClient();
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			HttpResponse serverResponse = httpClient.execute(httpPost);
			StatusLine statusLine = serverResponse.getStatusLine();
			if (statusLine.getStatusCode() < 400) {
				InputStream inputStream = serverResponse.getEntity().getContent();
				InputStreamReader inputReader = new InputStreamReader(inputStream);
				StringBuffer buffer = new StringBuffer();
				BufferedReader bufferedReader = new BufferedReader(inputReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					buffer.append(line);
				}
				response = buffer.toString();
				inputStream.close();
			} else {
				this.lastErrorCode = String.valueOf(statusLine.getStatusCode());
				this.lastErrorMessage = statusLine.getReasonPhrase();
				return null;
			}
		} catch (IOException e) {
			this.lastErrorCode = "-1";
			this.lastErrorMessage = e.getLocalizedMessage();
			return null;
		}
		return response;
	}

}