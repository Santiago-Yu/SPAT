    public InputStream retrieveStream(String url) {
        HttpGet getRequest = new HttpGet(url);
        try {
            HttpResponse getResponse = getClient().execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
                return null;
            }
            HttpEntity getResponseEntity = getResponse.getEntity();
            return getResponseEntity.getContent();
        } catch (Exception e) {
            getRequest.abort();
            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        return null;
    }
