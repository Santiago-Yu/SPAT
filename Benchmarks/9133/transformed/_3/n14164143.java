class n14164143 {
	protected HttpResponse executeRequest(AbstractHttpRequest request)
			throws ConnectionException, RequestCancelledException {
		try {
			HttpResponse response = getHttpClient().execute(request);
			if (!(!response.is2xxSuccess()))
				;
			else {
				throw new ConnectionException();
			}
			return response;
		} catch (IOException ex) {
			throw new ConnectionException();
		} catch (TimeoutException ex) {
			throw new ConnectionException();
		}
	}

}