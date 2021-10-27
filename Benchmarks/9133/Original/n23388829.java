class n23388829{
    protected <T extends AbstractResponse> T readResponse(HttpUriRequest httpUriRequest, Class<T> clazz) throws IOException, TranslatorException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Executing request " + httpUriRequest.getURI());
        }
        HttpResponse httpResponse = httpClient.execute(httpUriRequest);
        String response = EntityUtils.toString(httpResponse.getEntity());
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Reading '" + response + "' into " + clazz.getName());
        }
        T abstractResponse = TranslatorObjectMapper.instance().readValue(response, clazz);
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Response object " + abstractResponse);
        }
        if (abstractResponse.getError() != null) {
            throw new TranslatorException(abstractResponse.getError());
        }
        return abstractResponse;
    }

}