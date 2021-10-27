class n3046105{
    public GGLicenses getLicensesInfo() throws IllegalStateException, GGException, Exception {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("method", "gg.photos.licenses.getInfo"));
        qparams.add(new BasicNameValuePair("key", this.key));
        String url = REST_URL + "?" + URLEncodedUtils.format(qparams, "UTF-8");
        URI uri = new URI(url);
        HttpGet httpget = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpget);
        int status = response.getStatusLine().getStatusCode();
        errorCheck(response, status);
        InputStream content = response.getEntity().getContent();
        GGLicenses licenses = JAXB.unmarshal(content, GGLicenses.class);
        return licenses;
    }

}