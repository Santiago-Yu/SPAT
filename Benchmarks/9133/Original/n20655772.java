class n20655772{
    public static void main(String[] args) throws IOException {
        httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        loginLocalhostr();
        initialize();
        HttpOptions httpoptions = new HttpOptions(localhostrurl);
        HttpResponse myresponse = httpclient.execute(httpoptions);
        HttpEntity myresEntity = myresponse.getEntity();
        System.out.println(EntityUtils.toString(myresEntity));
        fileUpload();
    }

}