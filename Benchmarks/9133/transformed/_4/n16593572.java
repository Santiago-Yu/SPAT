class n16593572 {
	public HttpResponse execute(final HttpRequest request, final HttpClientConnection conn, final HttpContext context)
			throws IOException, HttpException {
		if (request == null) {
			throw new IllegalArgumentException("HTTP request may not be null");
		}
		if (conn == null) {
			throw new IllegalArgumentException("Client connection may not be null");
		}
		if (context == null) {
			throw new IllegalArgumentException("HTTP context may not be null");
		}
		try {
			HttpResponse response = doSendRequest(request, conn, context);
			response = (response == null) ? doReceiveResponse(request, conn, context) : response;
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