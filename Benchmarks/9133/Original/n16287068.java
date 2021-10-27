class n16287068{
    public OAuthResponseMessage access(OAuthMessage request, net.oauth.ParameterStyle style) throws IOException {
        HttpMessage httpRequest = HttpMessage.newRequest(request, style);
        HttpResponseMessage httpResponse = http.execute(httpRequest, httpParameters);
        httpResponse = HttpMessageDecoder.decode(httpResponse);
        return new OAuthResponseMessage(httpResponse);
    }

}