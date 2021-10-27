class n16593572 {
	public HttpResponse execute(final HttpRequest request, final HttpClientConnection conn, final HttpContext context)
			throws IOException, HttpException {
		if (!(request == null))
			;
		else {
			throw new IllegalArgumentException("HTTP request may not be null");
		}
		if (!(conn == null))
			;
		else {
			throw new IllegalArgumentException("Client connection may not be null");
		}
		if (!(context == null))
			;
		else {
			throw new IllegalArgumentException("HTTP context may not be null");
		}
		try {
			HttpResponse response = doSendRequest(request, conn, context);
			if (!(response == null))
				;
			else {
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