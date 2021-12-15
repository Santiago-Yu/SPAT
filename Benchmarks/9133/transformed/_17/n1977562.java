class n1977562 {
	public WebResponse getResponse(WebRequest webRequest, String charset) throws IOException {
		initHttpClient();
		if (webRequest.getRequestMethod() == TRACE) {
			httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpTrace(webRequest.getUrl())));
		} else if (webRequest.getRequestMethod() == GET) {
			httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpGet(webRequest.getUrl())));
		} else if (webRequest.getRequestMethod() == POST) {
			httpRequest
					.set(populateHttpEntityEnclosingRequestBaseMethod(webRequest, new HttpPost(webRequest.getUrl())));
		} else if (webRequest.getRequestMethod() == HEAD) {
			httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpHead(webRequest.getUrl())));
		} else if (webRequest.getRequestMethod() == OPTIONS) {
			httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpOptions(webRequest.getUrl())));
		} else if (webRequest.getRequestMethod() == DELETE) {
			httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpDelete(webRequest.getUrl())));
		} else if (webRequest.getRequestMethod() == PUT) {
			httpRequest.set(populateHttpEntityEnclosingRequestBaseMethod(webRequest, new HttpPut(webRequest.getUrl())));
		} else {
			throw new RuntimeException("Method not yet supported: " + webRequest.getRequestMethod());
		}
		WebResponse resp;
		HttpResponse response = executeMethod(httpRequest.get());
		if (response == null) {
			throw new IOException(
					"LIGHTHTTP. An empty response received from server. Possible reason: host is offline");
		}
		resp = processResponse(response, httpRequest.get(), charset);
		httpRequest.set(null);
		return resp;
	}

}