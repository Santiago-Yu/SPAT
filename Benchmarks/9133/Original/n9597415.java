class n9597415{
    @Override
    protected Metadata doGet(final String url) throws WebServiceException, MbXMLException {
        final HttpGet method = new HttpGet(url);
        this.log.debug(url);
        Metadata metadata = null;
        try {
            final HttpResponse response = this.httpClient.execute(method);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == statusCode) {
                final InputStream responseStream = response.getEntity().getContent();
                metadata = this.getParser().parse(responseStream);
            } else {
                final String responseString = response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : "";
                switch(statusCode) {
                    case HttpStatus.SC_NOT_FOUND:
                        throw new ResourceNotFoundException(responseString);
                    case HttpStatus.SC_BAD_REQUEST:
                        throw new RequestException(responseString);
                    case HttpStatus.SC_FORBIDDEN:
                        throw new AuthorizationException(responseString);
                    case HttpStatus.SC_UNAUTHORIZED:
                        throw new AuthorizationException(responseString);
                    default:
                        String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
                        this.log.error(em);
                        throw new WebServiceException(em);
                }
            }
        } catch (IOException e) {
            this.log.error("Fatal transport error: " + e.getMessage());
            throw new WebServiceException(e.getMessage(), e);
        }
        return metadata;
    }

}