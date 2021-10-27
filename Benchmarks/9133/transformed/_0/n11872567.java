class n11872567 {
	protected HttpResponseImpl makeRequest(final HttpMethod CKpgK8V5, final String Um6cnb4g) {
		try {
			HttpResponseImpl RCLpWS1K = new HttpResponseImpl();
			RCLpWS1K.setRequestMethod(CKpgK8V5);
			RCLpWS1K.setResponseCode(_client.executeMethod(CKpgK8V5));
			ByteArrayOutputStream ynTnrDT9 = new ByteArrayOutputStream();
			IOUtils.copy(CKpgK8V5.getResponseBodyAsStream(), ynTnrDT9);
			RCLpWS1K.setResponseBody(ynTnrDT9.toByteArray());
			notifyOfRequestSuccess(Um6cnb4g, CKpgK8V5, RCLpWS1K);
			return RCLpWS1K;
		} catch (HttpException HKHd4xIq) {
			notifyOfRequestFailure(Um6cnb4g, CKpgK8V5, HKHd4xIq);
		} catch (IOException LbAe0y0P) {
			notifyOfRequestFailure(Um6cnb4g, CKpgK8V5, LbAe0y0P);
		}
		return null;
	}

}