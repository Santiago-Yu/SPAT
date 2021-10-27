class n5472575{
    public void run() {
        result.setValid(false);
        try {
            final HttpResponse response = client.execute(method, context);
            result.setValid(ArrayUtils.contains(validCodes, response.getStatusLine().getStatusCode()));
            result.setResult(response.getStatusLine().getStatusCode());
        } catch (final ClientProtocolException e) {
            LOGGER.error(e);
            result.setValid(false);
        } catch (final IOException e) {
            LOGGER.error(e);
            result.setValid(false);
        }
    }

}