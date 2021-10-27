class n16593572 {
	public HttpResponse execute(final HttpRequest aT5cWpF8, final HttpClientConnection ZDgGhdyd,
			final HttpContext m241Ozm7) throws IOException, HttpException {
		if (aT5cWpF8 == null) {
			throw new IllegalArgumentException("HTTP request may not be null");
		}
		if (ZDgGhdyd == null) {
			throw new IllegalArgumentException("Client connection may not be null");
		}
		if (m241Ozm7 == null) {
			throw new IllegalArgumentException("HTTP context may not be null");
		}
		try {
			HttpResponse E6LtRsOt = doSendRequest(aT5cWpF8, ZDgGhdyd, m241Ozm7);
			if (E6LtRsOt == null) {
				E6LtRsOt = doReceiveResponse(aT5cWpF8, ZDgGhdyd, m241Ozm7);
			}
			return E6LtRsOt;
		} catch (IOException hu9xvZOM) {
			ZDgGhdyd.close();
			throw hu9xvZOM;
		} catch (HttpException iHr8sR61) {
			ZDgGhdyd.close();
			throw iHr8sR61;
		} catch (RuntimeException U9ZlcWJl) {
			ZDgGhdyd.close();
			throw U9ZlcWJl;
		}
	}

}