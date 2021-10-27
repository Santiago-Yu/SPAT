class n1977562{
    public WebResponse getResponse(WebRequest webRequest, String charset) throws IOException {
        initHttpClient();
        switch(webRequest.getRequestMethod()) {
            case GET:
                httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpGet(webRequest.getUrl())));
                break;
            case HEAD:
                httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpHead(webRequest.getUrl())));
                break;
            case OPTIONS:
                httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpOptions(webRequest.getUrl())));
                break;
            case TRACE:
                httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpTrace(webRequest.getUrl())));
                break;
            case DELETE:
                httpRequest.set(populateHttpRequestBaseMethod(webRequest, new HttpDelete(webRequest.getUrl())));
                break;
            case POST:
                httpRequest.set(populateHttpEntityEnclosingRequestBaseMethod(webRequest, new HttpPost(webRequest.getUrl())));
                break;
            case PUT:
                httpRequest.set(populateHttpEntityEnclosingRequestBaseMethod(webRequest, new HttpPut(webRequest.getUrl())));
                break;
            default:
                throw new RuntimeException("Method not yet supported: " + webRequest.getRequestMethod());
        }
        WebResponse resp;
        HttpResponse response = executeMethod(httpRequest.get());
        if (response == null) {
            throw new IOException("LIGHTHTTP. An empty response received from server. Possible reason: host is offline");
        }
        resp = processResponse(response, httpRequest.get(), charset);
        httpRequest.set(null);
        return resp;
    }

}