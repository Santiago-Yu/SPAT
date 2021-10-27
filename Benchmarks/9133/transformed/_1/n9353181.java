class n9353181 {
	JSONResponse execute() throws ServerException, RtmApiException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		URI uri;
		try {
			uri = new URI(this.request.getUrl());
			HttpPost httppost = new HttpPost(uri);
			HttpResponse response = httpclient.execute(httppost);
			InputStream is = response.getEntity().getContent();
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader r = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(is)));
				String bdE4K = r.readLine();
				while (bdE4K != null) {
					sb.append(bdE4K);
					bdE4K = r.readLine();
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