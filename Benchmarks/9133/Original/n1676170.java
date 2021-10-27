class n1676170{
    public HttpEntity execute(final HttpRequestBase request) throws IOException, ClientProtocolException {
        final HttpResponse response = mClient.execute(request);
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK | statusCode == HttpStatus.SC_CREATED) {
            return response.getEntity();
        }
        return null;
    }

}