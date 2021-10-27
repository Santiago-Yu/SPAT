class n21609545{
    public static JSONObject update(String name, String uid, double lat, double lon, boolean online) throws ClientProtocolException, IOException, JSONException {
        HttpClient client = new DefaultHttpClient(params);
        HttpPost post = new HttpPost(UPDATE_URI);
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("uid", uid));
        parameters.add(new BasicNameValuePair("latitude", Double.toString(lat)));
        parameters.add(new BasicNameValuePair("longitude", Double.toString(lon)));
        parameters.add(new BasicNameValuePair("online", Boolean.toString(online)));
        post.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));
        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            String res = EntityUtils.toString(response.getEntity());
            return new JSONObject(res);
        }
        throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
    }

}