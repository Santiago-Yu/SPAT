class n13531653{
    private static String processRequest(String request, HttpMethod method) {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        URI uri = null;
        try {
            uri = new URI(request);
            ClientHttpRequest clientHttpRequest = simpleClientHttpRequestFactory.createRequest(uri, method);
            ClientHttpResponse response = clientHttpRequest.execute();
            InputStream bodyInputStream = response.getBody();
            String body = org.apache.commons.io.IOUtils.toString(bodyInputStream);
            return body;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}