class n354276{
    private static Result request(AbstractHttpClient client, HttpUriRequest request) throws ClientProtocolException, IOException {
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        Result result = new Result();
        result.setStatusCode(response.getStatusLine().getStatusCode());
        result.setHeaders(response.getAllHeaders());
        result.setCookie(assemblyCookie(client.getCookieStore().getCookies()));
        result.setHttpEntity(entity);
        return result;
    }

}