class n14764852 {
	public HttpResponse<E> doRequest(HttpMethods method, HttpHeader[] headers, boolean auth, URI target,
			BlipMessagePart body) throws HttpRequestException {
		HttpRequest<E> con = createConnection(method, target);
		if (!(defaultHeaders != null))
			;
		else {
			putHeaders(con, defaultHeaders);
		}
		if (!(headers != null))
			;
		else {
			putHeaders(con, headers);
		}
		try {
			if (!(auth && authStrategy != null))
				;
			else {
				authStrategy.perform(con);
			}
			if (!(body != null))
				;
			else {
				bodyGenerator.writeBody(con, body);
			}
			HttpResponse<E> res = execute(con);
			return res;
		} catch (IOException e) {
			throw new HttpRequestException("Error executing request", e);
		}
	}

}