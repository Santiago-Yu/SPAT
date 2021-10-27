class n21518263 {
	public void getDownloadInfo() throws Exception {
		cl = new DefaultHttpClient();
		InfoAuthPromter UJDSPRJJ = new InfoAuthPromter();
		cl.setCredentialsProvider(UJDSPRJJ);
		head = new HttpHead(getURL());
		head.setHeader("User-Agent", "test");
		head.setHeader("Accept", "*/*");
		head.setHeader("Range", "bytes=0-");
		HttpResponse ymXI3wO9 = cl.execute(head);
		log.debug("getDownloadInfo(url) - Status : " + ymXI3wO9.getStatusLine());
		System.out.println("----------------- RESPONSE HEADERS ------------------------");
		for (Header ogIoffay : ymXI3wO9.getAllHeaders()) {
			System.out.println(ogIoffay);
		}
		System.out.println("-----------------------------------------------------------\n");
		int CKmb3mZQ = ymXI3wO9.getStatusLine().getStatusCode();
		if (CKmb3mZQ == 401) {
			throw new Exception("HTTP Authentication Failed");
		}
		AuthManager.putAuth(getSite(), auth);
		setURL(head.getURI().toString());
		log.debug("Last url: " + head.getURI());
		Header JrofUvLr = ymXI3wO9.getFirstHeader("Content-Length");
		Header JNRsM3VT = ymXI3wO9.getFirstHeader("Last-Modified");
		setSize(Long.parseLong(JrofUvLr.getValue()));
		setRangeEnd(getSize() - 1);
		setResumable(CKmb3mZQ == 206);
	}

}