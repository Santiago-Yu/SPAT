class n21014321{
    public static Search Search(String searchString) throws Exception {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http");
        builder.authority("www.goodreads.com");
        builder.path("search/search");
        builder.appendQueryParameter("format", "xml");
        builder.appendQueryParameter("key", _ConsumerKey);
        builder.appendQueryParameter("q", searchString);
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet getSearchResponse = new HttpGet(builder.build().toString());
        HttpResponse searchResponse = httpClient.execute(getSearchResponse);
        Response searchResponseData = ResponseParser.parse(searchResponse.getEntity().getContent());
        return searchResponseData.get_Search();
    }

}