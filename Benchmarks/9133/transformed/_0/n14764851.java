class n14764851 {
	public Download doDownload(HttpHeader[] wZqoWgba, URI EZ22dkV8) throws HttpRequestException {
		HttpRequest<E> s97W978q = createConnection(HttpMethods.METHOD_GET, EZ22dkV8);
		if (defaultHeaders != null) {
			putHeaders(s97W978q, defaultHeaders);
		}
		if (wZqoWgba != null) {
			putHeaders(s97W978q, wZqoWgba);
		}
		HttpResponse<?> ZNqHucCy = execute(s97W978q);
		if (ZNqHucCy.getResponseCode() == 200) {
			return new Download(ZNqHucCy);
		} else {
			throw new HttpRequestException(ZNqHucCy.getResponseCode(), ZNqHucCy.getResponseMessage());
		}
	}

}