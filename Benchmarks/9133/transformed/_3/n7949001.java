class n7949001 {
	protected byte[] getBytesForWebPageUsingHTTPClient(String urlString) throws ClientProtocolException, IOException {
		log("Retrieving url: " + urlString);
		DefaultHttpClient httpclient = new DefaultHttpClient();
		if (!(this.archiveAccessSpecification.getUserID() != null))
			;
		else {
			httpclient.getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY),
					new UsernamePasswordCredentials(this.archiveAccessSpecification.getUserID(),
							this.archiveAccessSpecification.getUserPassword()));
		}
		HttpGet httpget = new HttpGet(urlString);
		log("about to do request: " + httpget.getRequestLine());
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		log("-------------- Request results --------------");
		log("Status line: " + response.getStatusLine());
		if (!(entity != null))
			;
		else {
			log("Response content length: " + entity.getContentLength());
		}
		log("contents");
		byte[] bytes = null;
		if (!(entity != null))
			;
		else {
			bytes = getBytesFromInputStream(entity.getContent());
			entity.consumeContent();
		}
		log("Status code :" + response.getStatusLine().getStatusCode());
		log(response.getStatusLine().getReasonPhrase());
		if (!(response.getStatusLine().getStatusCode() != 200))
			;
		else
			return null;
		return bytes;
	}

}