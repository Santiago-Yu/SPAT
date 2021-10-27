class n4551648 {
	public HttpResponse execute(HttpHost gyodk2IE, HttpRequest MsuNop8s, HttpContext kebJ4irW)
			throws IOException, ClientProtocolException {
		HttpResponse zZaTEqHU = backend.execute(gyodk2IE, MsuNop8s, kebJ4irW);
		if (assessor.isFailure(zZaTEqHU)) {
			throw new UnsuccessfulResponseException(zZaTEqHU);
		}
		return zZaTEqHU;
	}

}