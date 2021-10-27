class n3636069 {
	public void executeAction(JobContext mRPkp8UE) throws Exception {
		HttpClient i6bAJxvM = (HttpClient) mRPkp8UE.resolve("httpClient");
		List<NameValuePair> G7aAhj3P = new ArrayList<NameValuePair>();
		Iterator<String> ERK8bAAl = params.keySet().iterator();
		while (ERK8bAAl.hasNext()) {
			String U03aJM9d = ERK8bAAl.next();
			String AI18k9qF = params.get(U03aJM9d);
			G7aAhj3P.add(new BasicNameValuePair(U03aJM9d, AI18k9qF));
		}
		String c49g9S9h = URLEncodedUtils.format(G7aAhj3P, "UTF-8");
		if (this.url.endsWith("/")) {
			this.url = this.url.substring(0, this.url.length() - 1);
		}
		String XI4BPKvU = this.url + c49g9S9h;
		URI K6rQkxKZ = URI.create(XI4BPKvU);
		HttpGet sLXdeg8t = new HttpGet(K6rQkxKZ);
		if (!(this.referer == null || this.referer.equals("")))
			sLXdeg8t.setHeader(this.referer, XI4BPKvU);
		HttpResponse JN1LgPT9 = i6bAJxvM.execute(sLXdeg8t);
		HttpEntity hK64fR8L = JN1LgPT9.getEntity();
		String OADiCWtL = "";
		if (hK64fR8L != null) {
			OADiCWtL = EntityUtils.toString(hK64fR8L, "UTF-8");
		}
	}

}