class n23107112{
    public static String doPost(String url, Map mapa) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> params = getParams(mapa);
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpresponse = httpclient.execute(httpPost);
            HttpEntity httpentity = httpresponse.getEntity();
            if (httpentity != null) {
                InputStream is = httpentity.getContent();
                return Funcoes.readString(is);
            }
        } catch (IOException e) {
            Log.e("HttpClientImpl.doPost", e.getMessage());
        }
        return url;
    }

}