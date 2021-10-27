class n3046104{
    public GGUser findByUsername(String userName) throws IllegalStateException, GGException, Exception {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("method", "gg.people.findByUsername"));
        qparams.add(new BasicNameValuePair("key", this.key));
        qparams.add(new BasicNameValuePair("username", userName));
        String url = REST_URL + "?" + URLEncodedUtils.format(qparams, "UTF-8");
        URI uri = new URI(url);
        HttpGet httpget = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpget);
        int status = response.getStatusLine().getStatusCode();
        errorCheck(response, status);
        InputStream content = response.getEntity().getContent();
        GGUser user = JAXB.unmarshal(content, GGUser.class);
        return user;
    }

}