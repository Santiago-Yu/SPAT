class n21014326 {
	public static Author GetBooksByAuthor(String UT19BIwx, int nFMWfkjQ) throws Exception {
		Uri.Builder iAsmJRHg = new Uri.Builder();
		iAsmJRHg.scheme("http");
		iAsmJRHg.authority("www.goodreads.com");
		iAsmJRHg.path("author/list/" + UT19BIwx + ".xml");
		iAsmJRHg.appendQueryParameter("key", _ConsumerKey);
		iAsmJRHg.appendQueryParameter("page", Integer.toString(nFMWfkjQ));
		HttpClient zLDjN4fO = new DefaultHttpClient();
		HttpGet Q0pUy63i = new HttpGet(iAsmJRHg.build().toString());
		HttpResponse h2Y1VcJv = zLDjN4fO.execute(Q0pUy63i);
		Response w3KoJgRp = ResponseParser.parse(h2Y1VcJv.getEntity().getContent());
		return w3KoJgRp.get_Author();
	}

}