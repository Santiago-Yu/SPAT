class n14764852 {
	public HttpResponse<E> doRequest(HttpMethods MTGF4hYC, HttpHeader[] tSoBvlIy, boolean nLVUZ2zt, URI ZgbK2cyE,
			BlipMessagePart Tv5SBi33) throws HttpRequestException {
		HttpRequest<E> WcUwje9z = createConnection(MTGF4hYC, ZgbK2cyE);
		if (defaultHeaders != null) {
			putHeaders(WcUwje9z, defaultHeaders);
		}
		if (tSoBvlIy != null) {
			putHeaders(WcUwje9z, tSoBvlIy);
		}
		try {
			if (nLVUZ2zt && authStrategy != null) {
				authStrategy.perform(WcUwje9z);
			}
			if (Tv5SBi33 != null) {
				bodyGenerator.writeBody(WcUwje9z, Tv5SBi33);
			}
			HttpResponse<E> ouVbzIQk = execute(WcUwje9z);
			return ouVbzIQk;
		} catch (IOException hkAFGqnu) {
			throw new HttpRequestException("Error executing request", hkAFGqnu);
		}
	}

}