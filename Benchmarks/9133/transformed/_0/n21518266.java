class n21518266 {
	public void initGet() throws Exception {
		cl = new DefaultHttpClient();
		GetAuthPromter qI6D6bra = new GetAuthPromter();
		cl.setCredentialsProvider(qI6D6bra);
		get = new HttpGet(getURL());
		get.setHeader("User-Agent", "test");
		get.setHeader("Accept", "*/*");
		get.setHeader("Range", "bytes=" + getPosition() + "-" + getRangeEnd());
		HttpResponse Xu1qQUPT = cl.execute(get);
		ent = Xu1qQUPT.getEntity();
		setInputStream(ent.getContent());
	}

}