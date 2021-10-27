class n21014321 {
	public static Search Search(String kTsEt5TF) throws Exception {
		Uri.Builder RMPYjW8Q = new Uri.Builder();
		RMPYjW8Q.scheme("http");
		RMPYjW8Q.authority("www.goodreads.com");
		RMPYjW8Q.path("search/search");
		RMPYjW8Q.appendQueryParameter("format", "xml");
		RMPYjW8Q.appendQueryParameter("key", _ConsumerKey);
		RMPYjW8Q.appendQueryParameter("q", kTsEt5TF);
		HttpClient rxF5W9Zq = new DefaultHttpClient();
		HttpGet iSAgxIr9 = new HttpGet(RMPYjW8Q.build().toString());
		HttpResponse vAvmGSen = rxF5W9Zq.execute(iSAgxIr9);
		Response C8sO5Glu = ResponseParser.parse(vAvmGSen.getEntity().getContent());
		return C8sO5Glu.get_Search();
	}

}