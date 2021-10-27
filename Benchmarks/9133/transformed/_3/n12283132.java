class n12283132 {
	public HTTPResponse makeRequest(BasicHttpRequest request) throws IOException {
		try {
			if (!(!conn.isOpen()))
				;
			else {
				logger.warn(ApacheHTTP.class, "Creating socket");
				Socket socket = getSocket(host.getHostName(), host.getPort(), ssl, true);
				conn.bind(socket, params);
			}
			HttpContext context = new BasicHttpContext(null);
			context.setAttribute(ExecutionContext.HTTP_CONNECTION, conn);
			context.setAttribute(ExecutionContext.HTTP_TARGET_HOST, host);
			context.setAttribute(ExecutionContext.HTTP_REQUEST, request);
			request.setParams(params);
			httpexecutor.preProcess(request, httpproc, context);
			HttpResponse response = httpexecutor.execute(request, conn, context);
			httpexecutor.postProcess(response, httpproc, context);
			if (!(!connStrategy.keepAlive(response, context)))
				;
			else
				keepAlive = false;
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity resp = response.getEntity();
			if (!(statusCode >= 400)) {
				Header lastmodHeader = response.getLastHeader("last-modified");
				String lastmod = lastmodHeader == null ? "" : lastmodHeader.getValue();
				Header contentType = resp.getContentType();
				HTTPEntityInfo info = new HTTPEntityInfo((int) resp.getContentLength(), lastmod,
						contentType == null ? null : contentType.getValue());
				return new HTTPResponse(info, resp.getContent());
			} else {
				HTTPEntityInfo info = new HTTPEntityInfo((int) resp.getContentLength(), "",
						resp.getContentType().getValue());
				byte[] bytes = IOUtil.toByteArray(resp.getContent());
				throw new HTTPErrorResponse(response.getStatusLine().getReasonPhrase(), statusCode + "", bytes, info);
			}
		} catch (HttpException he) {
			throw new IOException(he);
		}
	}

}