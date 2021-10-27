class n354276 {
	private static Result request(AbstractHttpClient Wj0OlLmS, HttpUriRequest wAcS0ut9)
			throws ClientProtocolException, IOException {
		HttpResponse VR6K3IIr = Wj0OlLmS.execute(wAcS0ut9);
		HttpEntity Tum3s4Cd = VR6K3IIr.getEntity();
		Result VDAhXGxK = new Result();
		VDAhXGxK.setStatusCode(VR6K3IIr.getStatusLine().getStatusCode());
		VDAhXGxK.setHeaders(VR6K3IIr.getAllHeaders());
		VDAhXGxK.setCookie(assemblyCookie(Wj0OlLmS.getCookieStore().getCookies()));
		VDAhXGxK.setHttpEntity(Tum3s4Cd);
		return VDAhXGxK;
	}

}