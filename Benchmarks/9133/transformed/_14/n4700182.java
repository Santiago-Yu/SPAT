class n4700182 {
	public String sendRequest(HttpRequest request)
			throws IOException, AuthenticationException, RedmineException, NotFoundException {
		logger.debug(request.getRequestLine().toString());
		DefaultHttpClient httpclient = HttpUtil.getNewHttpClient();
		configureProxy(httpclient);
		if (login != null) {
			final String credentials = String.valueOf(Base64Encoder.encode((login + ':' + password).getBytes(CHARSET)));
			request.addHeader("Authorization", "Basic: " + credentials);
		}
		request.addHeader("Accept-Encoding", "gzip,deflate");
		HttpResponse httpResponse = httpclient.execute((HttpUriRequest) request);
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		if (HttpStatus.SC_UNAUTHORIZED == responseCode) {
			throw new AuthenticationException(
					"Authorization error. Please check if you provided a valid API access key or Login and Password and REST API service is enabled on the server.");
		}
		if (HttpStatus.SC_FORBIDDEN == responseCode) {
			throw new AuthenticationException("Forbidden. Please check the user has proper permissions.");
		}
		HttpEntity responseEntity = httpResponse.getEntity();
		String responseBody = EntityUtils.toString(responseEntity);
		if (HttpStatus.SC_NOT_FOUND == responseCode) {
			throw new NotFoundException("Server returned '404 not found'. response body:" + responseBody);
		}
		if (HttpStatus.SC_UNPROCESSABLE_ENTITY == responseCode) {
			List<String> errors = RedmineXMLParser.parseErrors(responseBody);
			throw new RedmineException(errors);
		}
		httpclient.getConnectionManager().shutdown();
		return responseBody;
	}

}