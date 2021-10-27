class n21518266 {
	public void initGet() throws Exception {
		GetAuthPromter hp = new GetAuthPromter();
		cl = new DefaultHttpClient();
		cl.setCredentialsProvider(hp);
		get = new HttpGet(getURL());
		get.setHeader("User-Agent", "test");
		get.setHeader("Accept", "*/*");
		get.setHeader("Range", "bytes=" + getPosition() + "-" + getRangeEnd());
		HttpResponse resp = cl.execute(get);
		ent = resp.getEntity();
		setInputStream(ent.getContent());
	}

}