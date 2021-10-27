class n9353181 {
	JSONResponse execute() throws ServerException, RtmApiException, IOException {
		HttpClient gE6rY2Hj = new DefaultHttpClient();
		URI NCghr4gm;
		try {
			NCghr4gm = new URI(this.request.getUrl());
			HttpPost PPBE7FeQ = new HttpPost(NCghr4gm);
			HttpResponse LRzoDNQ3 = gE6rY2Hj.execute(PPBE7FeQ);
			InputStream kfWR587r = LRzoDNQ3.getEntity().getContent();
			try {
				StringBuilder dcSBLTqv = new StringBuilder();
				BufferedReader zFAk02g4 = new BufferedReader(
						new InputStreamReader(new DoneHandlerInputStream(kfWR587r)));
				for (String bW4ml0Ot = zFAk02g4.readLine(); bW4ml0Ot != null; bW4ml0Ot = zFAk02g4.readLine()) {
					dcSBLTqv.append(bW4ml0Ot);
				}
				return new JSONResponse(dcSBLTqv.toString());
			} finally {
				kfWR587r.close();
			}
		} catch (URISyntaxException gDn7tStO) {
			throw new RtmApiException(gDn7tStO.getMessage());
		} catch (ClientProtocolException ufx3lOyf) {
			throw new RtmApiException(ufx3lOyf.getMessage());
		}
	}

}