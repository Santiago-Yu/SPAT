class n9353182 {
	String test() throws ServerException, RtmApiException, IOException {
		URI uri;
		HttpClient httpclient = new DefaultHttpClient();
		try {
			uri = new URI(this.request.getUrl());
			HttpPost httppost = new HttpPost(uri);
			HttpResponse response = httpclient.execute(httppost);
			StringBuilder sb = new StringBuilder();
			InputStream is = response.getEntity().getContent();
			BufferedReader r = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(is)));
			for (String line = r.readLine(); line != null; line = r.readLine()) {
				sb.append(line);
			}
			return sb.toString();
		} catch (URISyntaxException e) {
			throw new RtmApiException(e.getMessage());
		} catch (ClientProtocolException e) {
			throw new RtmApiException(e.getMessage());
		}
	}

}