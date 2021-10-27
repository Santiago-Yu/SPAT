class n3046108{
    public GGPhotoInfo getPhotoInfo(String photoId, String language) throws IllegalStateException, GGException, Exception {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("method", "gg.photos.getInfo"));
        qparams.add(new BasicNameValuePair("key", this.key));
        qparams.add(new BasicNameValuePair("photo_id", photoId));
        if (null != language) {
            qparams.add(new BasicNameValuePair("language", language));
        }
        String url = REST_URL + "?" + URLEncodedUtils.format(qparams, "UTF-8");
        URI uri = new URI(url);
        HttpGet httpget = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpget);
        int status = response.getStatusLine().getStatusCode();
        errorCheck(response, status);
        InputStream content = response.getEntity().getContent();
        GGPhotoInfo photo = JAXB.unmarshal(content, GGPhotoInfo.class);
        return photo;
    }

}