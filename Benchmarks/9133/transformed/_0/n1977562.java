class n1977562 {
	public WebResponse getResponse(WebRequest wpeeUVRi, String XDMYdOtd) throws IOException {
		initHttpClient();
		switch (wpeeUVRi.getRequestMethod()) {
		case GET:
			httpRequest.set(populateHttpRequestBaseMethod(wpeeUVRi, new HttpGet(wpeeUVRi.getUrl())));
			break;
		case HEAD:
			httpRequest.set(populateHttpRequestBaseMethod(wpeeUVRi, new HttpHead(wpeeUVRi.getUrl())));
			break;
		case OPTIONS:
			httpRequest.set(populateHttpRequestBaseMethod(wpeeUVRi, new HttpOptions(wpeeUVRi.getUrl())));
			break;
		case TRACE:
			httpRequest.set(populateHttpRequestBaseMethod(wpeeUVRi, new HttpTrace(wpeeUVRi.getUrl())));
			break;
		case DELETE:
			httpRequest.set(populateHttpRequestBaseMethod(wpeeUVRi, new HttpDelete(wpeeUVRi.getUrl())));
			break;
		case POST:
			httpRequest.set(populateHttpEntityEnclosingRequestBaseMethod(wpeeUVRi, new HttpPost(wpeeUVRi.getUrl())));
			break;
		case PUT:
			httpRequest.set(populateHttpEntityEnclosingRequestBaseMethod(wpeeUVRi, new HttpPut(wpeeUVRi.getUrl())));
			break;
		default:
			throw new RuntimeException("Method not yet supported: " + wpeeUVRi.getRequestMethod());
		}
		WebResponse tlYzXWjQ;
		HttpResponse lCJPwZ1h = executeMethod(httpRequest.get());
		if (lCJPwZ1h == null) {
			throw new IOException(
					"LIGHTHTTP. An empty response received from server. Possible reason: host is offline");
		}
		tlYzXWjQ = processResponse(lCJPwZ1h, httpRequest.get(), XDMYdOtd);
		httpRequest.set(null);
		return tlYzXWjQ;
	}

}