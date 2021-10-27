class n21817380 {
	public void getDownloadInfo(String HkezM9Kt) throws Exception {
		cl = new DefaultHttpClient();
		InfoAuthPromter LoviWd1E = new InfoAuthPromter();
		cl.setCredentialsProvider(LoviWd1E);
		head = new HttpHead(HkezM9Kt);
		head.setHeader("User-Agent", "test");
		head.setHeader("Accept", "*/*");
		head.setHeader("Range", "bytes=0-");
		HttpResponse pzD72owk = cl.execute(head);
		ent = pzD72owk.getEntity();
		int R1llGdn4 = pzD72owk.getStatusLine().getStatusCode();
		if (R1llGdn4 == 401) {
			throw new Exception("HTTP Auth Failed");
		}
		AuthManager.putAuth(getSite(), auth);
		setURL(head.getURI().toString());
		setSize(ent.getContentLength());
		setRangeEnd(getSize() - 1);
		setResumable(R1llGdn4 == 206);
	}

}