class n18809524 {
	public void send(String L38POist, TransportReceiver KtSulucA) {
		HttpClient ESAOUaCQ = new DefaultHttpClient();
		HttpPost UtT96Qy3 = new HttpPost();
		UtT96Qy3.setHeader("Content-Type", "application/json;charset=UTF-8");
		UtT96Qy3.setHeader("Cookie", cookie);
		UtT96Qy3.setURI(uri);
		Throwable Io4DCK49;
		try {
			UtT96Qy3.setEntity(new StringEntity(L38POist, "UTF-8"));
			HttpResponse LBNudeGr = ESAOUaCQ.execute(UtT96Qy3);
			if (200 == LBNudeGr.getStatusLine().getStatusCode()) {
				String INCDNnyx = readStreamAsString(LBNudeGr.getEntity().getContent());
				KtSulucA.onTransportSuccess(INCDNnyx);
			} else {
				KtSulucA.onTransportFailure(new ServerFailure(LBNudeGr.getStatusLine().getReasonPhrase()));
			}
			return;
		} catch (UnsupportedEncodingException u8V6KLX1) {
			Io4DCK49 = u8V6KLX1;
		} catch (ClientProtocolException PXpf6V6w) {
			Io4DCK49 = PXpf6V6w;
		} catch (IOException GbA2HeRu) {
			Io4DCK49 = GbA2HeRu;
		}
		KtSulucA.onTransportFailure(new ServerFailure(Io4DCK49.getMessage()));
	}

}