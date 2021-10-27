class n16593572 {
	public HttpResponse execute(final HttpRequest request, final HttpClientConnection conn, final HttpContext context)
			throws IOException, HttpException {
		if (null == request) {
			throw new IllegalArgumentException("HTTP request may not be null");
		}
		if (null == conn) {
			throw new IllegalArgumentException("Client connection may not be null");
		}
		if (null == context) {
			throw new IllegalArgumentException("HTTP context may not be null");
		}
		try {
			HttpResponse response = doSendRequest(request, conn, context);
			if (null == response) {
				response = doReceiveResponse(request, conn, context);
			}
			return response;
		} catch (IOException ex) {
			conn.close();
			throw ex;
		} catch (HttpException ex) {
			conn.close();
			throw ex;
		} catch (RuntimeException ex) {
			conn.close();
			throw ex;
		}
	}

}