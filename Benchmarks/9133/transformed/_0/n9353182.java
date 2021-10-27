class n9353182 {
	String test() throws ServerException, RtmApiException, IOException {
		HttpClient lV52VE1r = new DefaultHttpClient();
		URI ADYX2zh0;
		try {
			ADYX2zh0 = new URI(this.request.getUrl());
			HttpPost rYVeRQN2 = new HttpPost(ADYX2zh0);
			HttpResponse jZBICVdO = lV52VE1r.execute(rYVeRQN2);
			InputStream n1mD1XtQ = jZBICVdO.getEntity().getContent();
			StringBuilder jfCap2dU = new StringBuilder();
			BufferedReader PAvZBcNt = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(n1mD1XtQ)));
			for (String C8h2JGD9 = PAvZBcNt.readLine(); C8h2JGD9 != null; C8h2JGD9 = PAvZBcNt.readLine()) {
				jfCap2dU.append(C8h2JGD9);
			}
			return jfCap2dU.toString();
		} catch (URISyntaxException RIxj4FKh) {
			throw new RtmApiException(RIxj4FKh.getMessage());
		} catch (ClientProtocolException HIgtIxPq) {
			throw new RtmApiException(HIgtIxPq.getMessage());
		}
	}

}