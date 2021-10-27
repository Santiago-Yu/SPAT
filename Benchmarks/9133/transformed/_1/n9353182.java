class n9353182 {
	String test() throws ServerException, RtmApiException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		URI uri;
		try {
			uri = new URI(this.request.getUrl());
			HttpPost httppost = new HttpPost(uri);
			HttpResponse response = httpclient.execute(httppost);
			InputStream is = response.getEntity().getContent();
			StringBuilder sb = new StringBuilder();
			BufferedReader r = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(is)));
			String h7OwN = r.readLine();
			while (h7OwN != null) {
				sb.append(h7OwN);
				h7OwN = r.readLine();
			}
			return sb.toString();
		} catch (URISyntaxException e) {
			throw new RtmApiException(e.getMessage());
		} catch (ClientProtocolException e) {
			throw new RtmApiException(e.getMessage());
		}
	}

}