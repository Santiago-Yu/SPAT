class n21505138{
    public String retrieve(String url) {
        HttpGet getRequest = new HttpGet(url);
        try {
            HttpResponse getResponse = client.execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
                return null;
            }
            HttpEntity getResponseEntity = getResponse.getEntity();
            if (getResponseEntity != null) {
                return EntityUtils.toString(getResponseEntity);
            }
        } catch (IOException e) {
            getRequest.abort();
            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        return null;
    }

}