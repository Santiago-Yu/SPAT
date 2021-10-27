class n1677874{
    public static String rename_file(String sessionid, String key, String newFileName) {
        String jsonstring = "";
        try {
            Log.d("current running function name:", "rename_file");
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("c", "Storage"));
            nameValuePairs.add(new BasicNameValuePair("m", "rename_file"));
            nameValuePairs.add(new BasicNameValuePair("new_name", newFileName));
            nameValuePairs.add(new BasicNameValuePair("key", key));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httppost.setHeader("Cookie", "PHPSESSID=" + sessionid);
            HttpResponse response = httpclient.execute(httppost);
            jsonstring = EntityUtils.toString(response.getEntity());
            Log.d("jsonStringReturned:", jsonstring);
            return jsonstring;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonstring;
    }

}