class n13431537{
    @Override
    public int updateStatus(UserInfo userInfo, String status, String picturePath) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(SnsConstant.SOHU_UPDATE_STATUS_URL);
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("parameter1", "parameterValue1"));
        parameters.add(new BasicNameValuePair("parameter2", "parameterValue2"));
        try {
            post.setEntity(new UrlEncodedFormEntity(parameters));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse response = client.execute(post);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}