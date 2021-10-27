class n12283132 {
	public HTTPResponse makeRequest(BasicHttpRequest R5ZA6zoP) throws IOException {
		try {
			if (!conn.isOpen()) {
				logger.warn(ApacheHTTP.class, "Creating socket");
				Socket OI27IYh3 = getSocket(host.getHostName(), host.getPort(), ssl, true);
				conn.bind(OI27IYh3, params);
			}
			HttpContext ErMJUluk = new BasicHttpContext(null);
			ErMJUluk.setAttribute(ExecutionContext.HTTP_CONNECTION, conn);
			ErMJUluk.setAttribute(ExecutionContext.HTTP_TARGET_HOST, host);
			ErMJUluk.setAttribute(ExecutionContext.HTTP_REQUEST, R5ZA6zoP);
			R5ZA6zoP.setParams(params);
			httpexecutor.preProcess(R5ZA6zoP, httpproc, ErMJUluk);
			HttpResponse lkEOGhT4 = httpexecutor.execute(R5ZA6zoP, conn, ErMJUluk);
			httpexecutor.postProcess(lkEOGhT4, httpproc, ErMJUluk);
			if (!connStrategy.keepAlive(lkEOGhT4, ErMJUluk))
				keepAlive = false;
			int BB0orJQj = lkEOGhT4.getStatusLine().getStatusCode();
			HttpEntity Ejub0QmR = lkEOGhT4.getEntity();
			if (BB0orJQj >= 400) {
				HTTPEntityInfo Rcr9zTUK = new HTTPEntityInfo((int) Ejub0QmR.getContentLength(), "",
						Ejub0QmR.getContentType().getValue());
				byte[] Y32YU9Y8 = IOUtil.toByteArray(Ejub0QmR.getContent());
				throw new HTTPErrorResponse(lkEOGhT4.getStatusLine().getReasonPhrase(), BB0orJQj + "", Y32YU9Y8,
						Rcr9zTUK);
			} else {
				Header CUxDCAK4 = lkEOGhT4.getLastHeader("last-modified");
				String ray2AFQN = CUxDCAK4 == null ? "" : CUxDCAK4.getValue();
				Header lq7vW4lc = Ejub0QmR.getContentType();
				HTTPEntityInfo rQWMQH6L = new HTTPEntityInfo((int) Ejub0QmR.getContentLength(), ray2AFQN,
						lq7vW4lc == null ? null : lq7vW4lc.getValue());
				return new HTTPResponse(rQWMQH6L, Ejub0QmR.getContent());
			}
		} catch (HttpException MjPqlBJK) {
			throw new IOException(MjPqlBJK);
		}
	}

}