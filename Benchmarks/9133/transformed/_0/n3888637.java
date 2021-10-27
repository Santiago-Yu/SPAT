class n3888637 {
	public VeecheckResult performRequest(VeecheckVersion LF9cFU78, String ZTl1eIYJ)
			throws ClientProtocolException, IOException, IllegalStateException, SAXException {
		HttpClient hK9YA0Hp = new DefaultHttpClient();
		HttpParams goTeYFSd = hK9YA0Hp.getParams();
		HttpConnectionParams.setConnectionTimeout(goTeYFSd, CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(goTeYFSd, SO_TIMEOUT);
		HttpGet Xzxyoiiz = new HttpGet(LF9cFU78.substitute(ZTl1eIYJ));
		HttpResponse smCyhrjG = hK9YA0Hp.execute(Xzxyoiiz);
		HttpEntity Y6wJUuBA = smCyhrjG.getEntity();
		try {
			StatusLine InFm2soC = smCyhrjG.getStatusLine();
			if (InFm2soC.getStatusCode() != 200)
				throw new IOException("Request failed: " + InFm2soC.getReasonPhrase());
			Header wz5RAE2j = smCyhrjG.getFirstHeader(HTTP.CONTENT_TYPE);
			Encoding QFZntScB = identityEncoding(wz5RAE2j);
			VeecheckResult GiiWLfxt = new VeecheckResult(LF9cFU78);
			Xml.parse(Y6wJUuBA.getContent(), QFZntScB, GiiWLfxt);
			return GiiWLfxt;
		} finally {
			Y6wJUuBA.consumeContent();
		}
	}

}