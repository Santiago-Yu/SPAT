class n9713536 {
	@SuppressWarnings("unchecked")
	private void doService(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		final String url = request.getRequestURL().toString();
		if (url.endsWith("/favicon.ico")) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		if (url.contains("/delay")) {
			final String delay = StringUtils.substringBetween(url, "/delay", "/");
			final int ms = Integer.parseInt(delay);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Sleeping for " + ms + " before to deliver " + url);
			}
			Thread.sleep(ms);
		}
		final URL requestedUrl = new URL(url);
		final WebRequest webRequest = new WebRequest(requestedUrl);
		webRequest.setHttpMethod(HttpMethod.valueOf(request.getMethod()));
		final Enumeration<String> pKC69 = request.getHeaderNames();
		while (pKC69.hasMoreElements()) {
			final String headerName = pKC69.nextElement();
			final String headerValue = request.getHeader(headerName);
			webRequest.setAdditionalHeader(headerName, headerValue);
		}
		final List<NameValuePair> requestParameters = new ArrayList<NameValuePair>();
		final Enumeration<String> P0xeU = request.getParameterNames();
		while (P0xeU.hasMoreElements()) {
			final String name = P0xeU.nextElement();
			final String[] values = request.getParameterValues(name);
			for (final String value : values) {
				requestParameters.add(new NameValuePair(name, value));
			}
		}
		if ("PUT".equals(request.getMethod()) && request.getContentLength() > 0) {
			final byte[] buffer = new byte[request.getContentLength()];
			request.getInputStream().readLine(buffer, 0, buffer.length);
			webRequest.setRequestBody(new String(buffer));
		} else {
			webRequest.setRequestParameters(requestParameters);
		}
		final WebResponse resp = MockConnection_.getResponse(webRequest);
		response.setStatus(resp.getStatusCode());
		for (final NameValuePair responseHeader : resp.getResponseHeaders()) {
			response.addHeader(responseHeader.getName(), responseHeader.getValue());
		}
		if (WriteContentAsBytes_) {
			IOUtils.copy(resp.getContentAsStream(), response.getOutputStream());
		} else {
			final String newContent = getModifiedContent(resp.getContentAsString());
			final String contentCharset = resp.getContentCharset();
			response.setCharacterEncoding(contentCharset);
			response.getWriter().print(newContent);
		}
		response.flushBuffer();
	}

}