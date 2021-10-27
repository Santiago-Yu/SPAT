class n17974663{
    public boolean searchEntity(String login, String password, String searcheId, OutputStream os) throws SynchronizationException {
        HttpClient client = new SSLHttpClient();
        try {
            StringBuilder builder = new StringBuilder(url).append("?" + CMD_PARAM + "=" + CMD_SEARCH).append("&" + LOGIN_PARAM + "=" + URLEncoder.encode(login, "UTF-8")).append("&" + PASSWD_PARAM + "=" + URLEncoder.encode(password, "UTF-8")).append("&" + SEARCH_PARAM + "=" + searcheId);
            HttpGet method = httpGetMethod(builder.toString());
            HttpResponse response = client.execute(method);
            Header header = response.getFirstHeader(HEADER_NAME);
            if (header != null && HEADER_VALUE.equals(HEADER_VALUE)) {
                int code = response.getStatusLine().getStatusCode();
                if (code == HttpStatus.SC_OK) {
                    long expectedLength = response.getEntity().getContentLength();
                    InputStream is = response.getEntity().getContent();
                    FileUtils.writeInFile(is, os, expectedLength);
                    return true;
                } else {
                    throw new SynchronizationException("Command 'search' : HTTP error code returned." + code, SynchronizationException.ERROR_SEARCH);
                }
            } else {
                throw new SynchronizationException("HTTP header is invalid", SynchronizationException.ERROR_SEARCH);
            }
        } catch (Exception e) {
            throw new SynchronizationException("Command 'search' -> ", e, SynchronizationException.ERROR_SEARCH);
        }
    }

}