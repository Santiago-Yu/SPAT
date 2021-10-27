class n21518263 {
	public void getDownloadInfo() throws Exception {
		InfoAuthPromter hp = new InfoAuthPromter();
		cl = new DefaultHttpClient();
		cl.setCredentialsProvider(hp);
		head = new HttpHead(getURL());
		head.setHeader("User-Agent", "test");
		head.setHeader("Accept", "*/*");
		head.setHeader("Range", "bytes=0-");
		HttpResponse resp = cl.execute(head);
		log.debug("getDownloadInfo(url) - Status : " + resp.getStatusLine());
		System.out.println("----------------- RESPONSE HEADERS ------------------------");
		for (Header h : resp.getAllHeaders()) {
			System.out.println(h);
		}
		System.out.println("-----------------------------------------------------------\n");
		int code = resp.getStatusLine().getStatusCode();
		if (code == 401) {
			throw new Exception("HTTP Authentication Failed");
		}
		AuthManager.putAuth(getSite(), auth);
		setURL(head.getURI().toString());
		log.debug("Last url: " + head.getURI());
		Header hsize = resp.getFirstHeader("Content-Length");
		Header hmod = resp.getFirstHeader("Last-Modified");
		setSize(Long.parseLong(hsize.getValue()));
		setRangeEnd(getSize() - 1);
		setResumable(code == 206);
	}

}