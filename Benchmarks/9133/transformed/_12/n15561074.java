class n15561074 {
	private void httpDo(HttpUriRequest hr, String url, Map<String, String> headers, AjaxStatus status)
			throws ClientProtocolException, IOException {
		if (AGENT != null) {
			hr.addHeader("User-Agent", AGENT);
		}
		if (headers != null) {
			for (String name : headers.keySet()) {
				hr.addHeader(name, headers.get(name));
			}
		}
		if (GZIP && headers == null || !headers.containsKey("Accept-Encoding")) {
			hr.addHeader("Accept-Encoding", "gzip");
		}
		String cookie = makeCookie();
		if (cookie != null) {
			hr.addHeader("Cookie", cookie);
		}
		if (ah != null) {
			ah.applyToken(this, hr);
		}
		DefaultHttpClient client = getClient();
		HttpContext context = new BasicHttpContext();
		CookieStore cookieStore = new BasicCookieStore();
		context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		HttpResponse response = client.execute(hr, context);
		byte[] data = null;
		String redirect = url;
		int code = response.getStatusLine().getStatusCode();
		String message = response.getStatusLine().getReasonPhrase(), error = null;
		if (code < 200 || code >= 300) {
			try {
				HttpEntity entity = response.getEntity();
				byte[] s = AQUtility.toBytes(entity.getContent());
				error = new String(s, "UTF-8");
				AQUtility.debug("error", error);
			} catch (Exception e) {
				AQUtility.debug(e);
			}
		} else {
			HttpEntity entity = response.getEntity();
			HttpHost currentHost = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
			HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
			redirect = currentHost.toURI() + currentReq.getURI();
			int size = Math.max(32, Math.min(1024 * 64, (int) entity.getContentLength()));
			PredefinedBAOS baos = new PredefinedBAOS(size);
			Header encoding = entity.getContentEncoding();
			if (encoding != null && encoding.getValue().equalsIgnoreCase("gzip")) {
				InputStream is = new GZIPInputStream(entity.getContent());
				AQUtility.copy(is, baos);
			} else {
				entity.writeTo(baos);
			}
			data = baos.toByteArray();
		}
		AQUtility.debug("response", code);
		if (data != null) {
			AQUtility.debug(data.length, url);
		}
		status.code(code).message(message).error(error).redirect(redirect).time(new Date()).data(data).client(client)
				.context(context).headers(response.getAllHeaders());
	}

}