class n17114096{
    public HttpResponse executeHttpGetRequest(String uri, Map<String, Object> parameters) throws HttpTestClientException {
        HttpGet httpGet = new HttpGet(uri);
        if (parameters != null) {
            httpGet.setParams(createBasicParameters(parameters));
        }
        return executeHttp(httpGet);
    }

}