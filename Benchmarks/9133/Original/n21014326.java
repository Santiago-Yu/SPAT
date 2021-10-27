class n21014326{
    public static Author GetBooksByAuthor(String authorId, int page) throws Exception {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http");
        builder.authority("www.goodreads.com");
        builder.path("author/list/" + authorId + ".xml");
        builder.appendQueryParameter("key", _ConsumerKey);
        builder.appendQueryParameter("page", Integer.toString(page));
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet getResponse = new HttpGet(builder.build().toString());
        HttpResponse response = httpClient.execute(getResponse);
        Response responseData = ResponseParser.parse(response.getEntity().getContent());
        return responseData.get_Author();
    }

}