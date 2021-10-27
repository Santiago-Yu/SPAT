class n21540492{
    public InputStream getStream(Hashtable<String, String> pValue) throws IOException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Enumeration<String> enm = pValue.keys();
        String key;
        while (enm.hasMoreElements()) {
            key = enm.nextElement();
            nvps.add(new BasicNameValuePair(key, pValue.get(key)));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        return entity.getContent();
    }

}