class n3046106{
    public GGMunicipalities getListMunicipalities() throws IllegalStateException, GGException, Exception {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("method", "gg.photos.geo.getListMunicipality"));
        qparams.add(new BasicNameValuePair("key", this.key));
        String url = REST_URL + "?" + URLEncodedUtils.format(qparams, "UTF-8");
        URI uri = new URI(url);
        HttpGet httpget = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpget);
        int status = response.getStatusLine().getStatusCode();
        errorCheck(response, status);
        InputStream content = response.getEntity().getContent();
        GGMunicipalities municipalities = JAXB.unmarshal(content, GGMunicipalities.class);
        return municipalities;
    }

}