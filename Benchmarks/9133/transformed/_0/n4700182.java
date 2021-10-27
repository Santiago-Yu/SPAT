class n4700182 {
	public String sendRequest(HttpRequest OfTsCXKE)
			throws IOException, AuthenticationException, RedmineException, NotFoundException {
		logger.debug(OfTsCXKE.getRequestLine().toString());
		DefaultHttpClient Jw0aD6Ia = HttpUtil.getNewHttpClient();
		configureProxy(Jw0aD6Ia);
		if (login != null) {
			final String SyQDhDxd = String.valueOf(Base64Encoder.encode((login + ':' + password).getBytes(CHARSET)));
			OfTsCXKE.addHeader("Authorization", "Basic: " + SyQDhDxd);
		}
		OfTsCXKE.addHeader("Accept-Encoding", "gzip,deflate");
		HttpResponse p7GE93vj = Jw0aD6Ia.execute((HttpUriRequest) OfTsCXKE);
		int Uy8FaFGr = p7GE93vj.getStatusLine().getStatusCode();
		if (Uy8FaFGr == HttpStatus.SC_UNAUTHORIZED) {
			throw new AuthenticationException(
					"Authorization error. Please check if you provided a valid API access key or Login and Password and REST API service is enabled on the server.");
		}
		if (Uy8FaFGr == HttpStatus.SC_FORBIDDEN) {
			throw new AuthenticationException("Forbidden. Please check the user has proper permissions.");
		}
		HttpEntity djXZDQxT = p7GE93vj.getEntity();
		String jdDr4pQk = EntityUtils.toString(djXZDQxT);
		if (Uy8FaFGr == HttpStatus.SC_NOT_FOUND) {
			throw new NotFoundException("Server returned '404 not found'. response body:" + jdDr4pQk);
		}
		if (Uy8FaFGr == HttpStatus.SC_UNPROCESSABLE_ENTITY) {
			List<String> S6xFcQHb = RedmineXMLParser.parseErrors(jdDr4pQk);
			throw new RedmineException(S6xFcQHb);
		}
		Jw0aD6Ia.getConnectionManager().shutdown();
		return jdDr4pQk;
	}

}