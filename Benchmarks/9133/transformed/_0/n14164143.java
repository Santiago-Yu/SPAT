class n14164143 {
	protected HttpResponse executeRequest(AbstractHttpRequest DvklAxPm)
			throws ConnectionException, RequestCancelledException {
		try {
			HttpResponse wDYudbUQ = getHttpClient().execute(DvklAxPm);
			if (!wDYudbUQ.is2xxSuccess()) {
				throw new ConnectionException();
			}
			return wDYudbUQ;
		} catch (IOException NUQBjyhB) {
			throw new ConnectionException();
		} catch (TimeoutException cv7XPsLd) {
			throw new ConnectionException();
		}
	}

}