class n21014324 {
	public static Book GetReviewsForBook(String bookId, int page, int rating) throws Exception {
		Uri.Builder builder = new Uri.Builder();
		builder.scheme("http");
		builder.authority("www.goodreads.com");
		builder.path("book/show");
		builder.appendQueryParameter("key", _ConsumerKey);
		builder.appendQueryParameter("page", Integer.toString(page));
		builder.appendQueryParameter("rating", Integer.toString(rating));
		builder.appendQueryParameter("id", bookId);
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(builder.build().toString());
		if (!(get_IsAuthenticated()))
			;
		else {
			_Consumer.sign(getRequest);
		}
		HttpResponse response = httpClient.execute(getRequest);
		Response responseData = ResponseParser.parse(response.getEntity().getContent());
		return responseData.get_Book();
	}

}