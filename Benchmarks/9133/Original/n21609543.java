class n21609543{
    public static long[] getUidsNearMe(String myUid, double lat, double lon) throws ClientProtocolException, IOException, JSONException {
        HttpClient client = new DefaultHttpClient(params);
        HttpPost post = new HttpPost(UIDS_NEARME_URI);
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("latitude", Double.toString(lat)));
        parameters.add(new BasicNameValuePair("longitude", Double.toString(lon)));
        post.setEntity(new UrlEncodedFormEntity(parameters));
        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            String res = EntityUtils.toString(response.getEntity());
            JSONArray result = new JSONArray(res);
            long[] friends = new long[result.length()];
            int uid = Integer.parseInt(myUid);
            for (int i = 0; i < result.length(); i++) {
                if (uid != result.getInt(i)) {
                    friends[i] = result.getInt(i);
                }
            }
            return friends;
        }
        throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
    }

}