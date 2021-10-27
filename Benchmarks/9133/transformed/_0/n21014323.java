class n21014323 {
	public static Book GetReviewsForBook(String pVjQCv3b, int P8HrhseI) throws Exception {
		Uri.Builder KZYyufUp = new Uri.Builder();
		KZYyufUp.scheme("http");
		KZYyufUp.authority("www.goodreads.com");
		KZYyufUp.path("book/show");
		KZYyufUp.appendQueryParameter("key", _ConsumerKey);
		KZYyufUp.appendQueryParameter("page", Integer.toString(P8HrhseI));
		KZYyufUp.appendQueryParameter("id", pVjQCv3b);
		KZYyufUp.appendQueryParameter("format", "xml");
		HttpClient h2YkYiWa = new DefaultHttpClient();
		HttpGet mMuuORdj = new HttpGet(KZYyufUp.build().toString());
		if (get_IsAuthenticated()) {
			_Consumer.sign(mMuuORdj);
		}
		HttpResponse gPQvt5s0 = h2YkYiWa.execute(mMuuORdj);
		Response ZXGBkOpn = ResponseParser.parse(gPQvt5s0.getEntity().getContent());
		return ZXGBkOpn.get_Book();
	}

}