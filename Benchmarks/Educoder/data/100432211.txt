    public static String connRemote(JSONObject jsonObject, String OPCode) {
        String retSrc = "";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(AZConstants.validateURL);
            HttpParams httpParams = new BasicHttpParams();
            List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
            nameValuePair.add(new BasicNameValuePair(AZConstants.ACTION_TYPE, OPCode));
            nameValuePair.add(new BasicNameValuePair(AZConstants.PARAM, jsonObject.toString()));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
            httpPost.setParams(httpParams);
            HttpResponse response = httpClient.execute(httpPost);
            retSrc = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return retSrc;
    }
