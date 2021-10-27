class n9353181 {
	JSONResponse execute() throws ServerException, RtmApiException, IOException {
		URI uri;
		HttpClient httpclient = new DefaultHttpClient();
		try {
			uri = new URI(this.request.getUrl());
			HttpPost httppost = new HttpPost(uri);
			HttpResponse response = httpclient.execute(httppost);
			InputStream is = response.getEntity().getContent();
			try {
				BufferedReader r = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(is)));
				StringBuilder sb = new StringBuilder();
				for (String line = r.readLine(); line != null; line = r.readLine()) {
					sb.append(line);
				}
				return new JSONResponse(sb.toString());
			} finally {
				is.close();
			}
		} catch (URISyntaxException e) {
			throw new RtmApiException(e.getMessage());
		} catch (ClientProtocolException e) {
			throw new RtmApiException(e.getMessage());
		}
	}

}