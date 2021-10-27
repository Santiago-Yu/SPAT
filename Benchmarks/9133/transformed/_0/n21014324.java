class n21014324 {
	public static Book GetReviewsForBook(String h4QE2JjN, int roayxP8Z, int Q01eA8YX) throws Exception {
		Uri.Builder wWLSrJGL = new Uri.Builder();
		wWLSrJGL.scheme("http");
		wWLSrJGL.authority("www.goodreads.com");
		wWLSrJGL.path("book/show");
		wWLSrJGL.appendQueryParameter("key", _ConsumerKey);
		wWLSrJGL.appendQueryParameter("page", Integer.toString(roayxP8Z));
		wWLSrJGL.appendQueryParameter("rating", Integer.toString(Q01eA8YX));
		wWLSrJGL.appendQueryParameter("id", h4QE2JjN);
		HttpClient NP48uBN9 = new DefaultHttpClient();
		HttpGet sHXZ9AtV = new HttpGet(wWLSrJGL.build().toString());
		if (get_IsAuthenticated()) {
			_Consumer.sign(sHXZ9AtV);
		}
		HttpResponse zzyWrPAe = NP48uBN9.execute(sHXZ9AtV);
		Response NYCgOIif = ResponseParser.parse(zzyWrPAe.getEntity().getContent());
		return NYCgOIif.get_Book();
	}

}