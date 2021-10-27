class n7422527 {
	public HttpResponseMessage execute(HttpMessage request, Map<String, Object> parameters) throws IOException {
		final String method = request.method, url = request.url.toExternalForm();
		final InputStream body = request.getBody();
		final boolean isDelete = DELETE.equalsIgnoreCase(method), isPost = POST.equalsIgnoreCase(method);
		final boolean isPut = PUT.equalsIgnoreCase(method);
		byte[] excerpt = null;
		HttpMethod httpMethod;
		if (isPost || isPut) {
			EntityEnclosingMethod entityEnclosingMethod = isPost ? new PostMethod(url) : new PutMethod(url);
			if (body != null) {
				ExcerptInputStream e = new ExcerptInputStream(body);
				String length = request.removeHeaders(HttpMessage.CONTENT_LENGTH);
				entityEnclosingMethod.setRequestEntity((length == null) ? new InputStreamRequestEntity(e)
						: new InputStreamRequestEntity(e, Long.parseLong(length)));
				excerpt = e.getExcerpt();
			}
			httpMethod = entityEnclosingMethod;
		} else if (isDelete) {
			httpMethod = new DeleteMethod(url);
		} else {
			httpMethod = new GetMethod(url);
		}
		for (Map.Entry<String, Object> p : parameters.entrySet()) {
			String name = p.getKey(), value = p.getValue().toString();
			if (FOLLOW_REDIRECTS.equals(name)) {
				httpMethod.setFollowRedirects(Boolean.parseBoolean(value));
			} else if (READ_TIMEOUT.equals(name)) {
				httpMethod.getParams().setIntParameter(HttpMethodParams.SO_TIMEOUT, Integer.parseInt(value));
			}
		}
		for (Map.Entry<String, String> header : request.headers) {
			httpMethod.addRequestHeader(header.getKey(), header.getValue());
		}
		HttpClient client = clientPool.getHttpClient(new URL(httpMethod.getURI().toString()));
		client.executeMethod(httpMethod);
		return new HttpMethodResponse(httpMethod, excerpt, request.getContentCharset());
	}

}