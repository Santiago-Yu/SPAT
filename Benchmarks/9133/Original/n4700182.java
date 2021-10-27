class n4700182{
    public String sendRequest(HttpRequest request) throws IOException, AuthenticationException, RedmineException, NotFoundException {
        logger.debug(request.getRequestLine().toString());
        DefaultHttpClient httpclient = HttpUtil.getNewHttpClient();
        configureProxy(httpclient);
        if (login != null) {
            final String credentials = String.valueOf(Base64Encoder.encode((login + ':' + password).getBytes(CHARSET)));
            request.addHeader("Authorization", "Basic: " + credentials);
        }
        request.addHeader("Accept-Encoding", "gzip,deflate");
        HttpResponse httpResponse = httpclient.execute((HttpUriRequest) request);
        int responseCode = httpResponse.getStatusLine().getStatusCode();
        if (responseCode == HttpStatus.SC_UNAUTHORIZED) {
            throw new AuthenticationException("Authorization error. Please check if you provided a valid API access key or Login and Password and REST API service is enabled on the server.");
        }
        if (responseCode == HttpStatus.SC_FORBIDDEN) {
            throw new AuthenticationException("Forbidden. Please check the user has proper permissions.");
        }
        HttpEntity responseEntity = httpResponse.getEntity();
        String responseBody = EntityUtils.toString(responseEntity);
        if (responseCode == HttpStatus.SC_NOT_FOUND) {
            throw new NotFoundException("Server returned '404 not found'. response body:" + responseBody);
        }
        if (responseCode == HttpStatus.SC_UNPROCESSABLE_ENTITY) {
            List<String> errors = RedmineXMLParser.parseErrors(responseBody);
            throw new RedmineException(errors);
        }
        httpclient.getConnectionManager().shutdown();
        return responseBody;
    }

}