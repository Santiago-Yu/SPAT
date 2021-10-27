    public boolean requestServerModifications(UUID sessionId, OutputStream out) throws SynchronizationException {
        HttpClient client = new SSLHttpClient();
        StringBuilder builder = new StringBuilder(url).append("?" + SESSION_PARAM + "=" + sessionId).append("&" + CMD_PARAM + "=" + CMD_SERVERMODIF);
        HttpGet method = httpGetMethod(builder.toString());
        try {
            HttpResponse response = client.execute(method);
            Header header = response.getFirstHeader(HEADER_NAME);
            if (header != null && HEADER_VALUE.equals(header.getValue())) {
                int code = response.getStatusLine().getStatusCode();
                if (code == HttpStatus.SC_OK) {
                    long expectedLength = response.getEntity().getContentLength();
                    InputStream is = response.getEntity().getContent();
                    FileUtils.writeInFile(is, out, expectedLength);
                    return true;
                } else {
                    throw new SynchronizationException("Command 'receive' : HTTP error code returned." + code, SynchronizationException.ERROR_RECEIVE);
                }
            } else {
                throw new SynchronizationException("HTTP header is invalid", SynchronizationException.ERROR_RECEIVE);
            }
        } catch (Exception e) {
            throw new SynchronizationException("Command 'receive' -> ", e, SynchronizationException.ERROR_RECEIVE);
        }
    }
