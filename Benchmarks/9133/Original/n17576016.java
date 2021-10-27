class n17576016{
    public static String post(String actionUrl, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(actionUrl);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}