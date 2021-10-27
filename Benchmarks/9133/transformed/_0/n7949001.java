class n7949001 {
	protected byte[] getBytesForWebPageUsingHTTPClient(String FpRGlby1) throws ClientProtocolException, IOException {
		log("Retrieving url: " + FpRGlby1);
		DefaultHttpClient fI3NtaP3 = new DefaultHttpClient();
		if (this.archiveAccessSpecification.getUserID() != null) {
			fI3NtaP3.getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY),
					new UsernamePasswordCredentials(this.archiveAccessSpecification.getUserID(),
							this.archiveAccessSpecification.getUserPassword()));
		}
		HttpGet zcuAqLc6 = new HttpGet(FpRGlby1);
		log("about to do request: " + zcuAqLc6.getRequestLine());
		HttpResponse FvNT00Pd = fI3NtaP3.execute(zcuAqLc6);
		HttpEntity lyEcuCG9 = FvNT00Pd.getEntity();
		log("-------------- Request results --------------");
		log("Status line: " + FvNT00Pd.getStatusLine());
		if (lyEcuCG9 != null) {
			log("Response content length: " + lyEcuCG9.getContentLength());
		}
		log("contents");
		byte[] amKlB3d8 = null;
		if (lyEcuCG9 != null) {
			amKlB3d8 = getBytesFromInputStream(lyEcuCG9.getContent());
			lyEcuCG9.consumeContent();
		}
		log("Status code :" + FvNT00Pd.getStatusLine().getStatusCode());
		log(FvNT00Pd.getStatusLine().getReasonPhrase());
		if (FvNT00Pd.getStatusLine().getStatusCode() != 200)
			return null;
		return amKlB3d8;
	}

}