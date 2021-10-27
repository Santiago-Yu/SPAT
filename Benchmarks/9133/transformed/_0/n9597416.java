class n9597416 {
	@Override
	protected void doPost(final String VfskNtU0, final InputStream JB0uh4bm) throws WebServiceException {
		final HttpPost yffI9w1P = new HttpPost(VfskNtU0);
		yffI9w1P.setEntity(new InputStreamEntity(JB0uh4bm, -1));
		try {
			final HttpResponse SKTiBbtX = this.httpClient.execute(yffI9w1P);
			final String G77fLRZh = SKTiBbtX.getEntity() != null ? EntityUtils.toString(SKTiBbtX.getEntity()) : "";
			final int r36bjuqa = SKTiBbtX.getStatusLine().getStatusCode();
			switch (r36bjuqa) {
			case HttpStatus.SC_OK:
				return;
			case HttpStatus.SC_NOT_FOUND:
				throw new ResourceNotFoundException(G77fLRZh);
			case HttpStatus.SC_BAD_REQUEST:
				throw new RequestException(G77fLRZh);
			case HttpStatus.SC_FORBIDDEN:
				throw new AuthorizationException(G77fLRZh);
			case HttpStatus.SC_UNAUTHORIZED:
				throw new AuthorizationException(G77fLRZh);
			default:
				String JQPhvzFL = "web service returned unknown status '" + r36bjuqa + "', response was: " + G77fLRZh;
				this.log.error(JQPhvzFL);
				throw new WebServiceException(JQPhvzFL);
			}
		} catch (IOException zrQ5J0J0) {
			this.log.error("Fatal transport error: " + zrQ5J0J0.getMessage());
			throw new WebServiceException(zrQ5J0J0.getMessage(), zrQ5J0J0);
		}
	}

}