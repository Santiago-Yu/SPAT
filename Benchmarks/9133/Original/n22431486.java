class n22431486{
    public static String doPostEntity(String URL, List<NameValuePair> params) {
        try {
            OauthUtil util = new OauthUtil();
            URI uri = new URI(URL);
            HttpClient httpclient = util.getNewHttpClient();
            HttpPost postMethod = new HttpPost(uri);
            postMethod.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = httpclient.execute(postMethod);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                String strResult = EntityUtils.toString(httpResponse.getEntity());
                Log.i("DEBUG", "result: " + strResult);
                String token;
                try {
                    JSONObject obj = new JSONObject(strResult);
                    token = obj.getString("access_token");
                } catch (Exception e) {
                    token = strResult.substring(strResult.indexOf("access_token=") + 13);
                }
                return token;
            }
        } catch (Exception e) {
            Log.i("DEBUG", e.toString());
        }
        return null;
    }

}