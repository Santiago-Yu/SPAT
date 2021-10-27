class n3888637{
    public VeecheckResult performRequest(VeecheckVersion version, String uri) throws ClientProtocolException, IOException, IllegalStateException, SAXException {
        HttpClient client = new DefaultHttpClient();
        HttpParams params = client.getParams();
        HttpConnectionParams.setConnectionTimeout(params, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, SO_TIMEOUT);
        HttpGet request = new HttpGet(version.substitute(uri));
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        try {
            StatusLine line = response.getStatusLine();
            if (line.getStatusCode() != 200) throw new IOException("Request failed: " + line.getReasonPhrase());
            Header header = response.getFirstHeader(HTTP.CONTENT_TYPE);
            Encoding encoding = identityEncoding(header);
            VeecheckResult handler = new VeecheckResult(version);
            Xml.parse(entity.getContent(), encoding, handler);
            return handler;
        } finally {
            entity.consumeContent();
        }
    }

}