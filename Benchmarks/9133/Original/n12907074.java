class n12907074{
    public static int sendButton(String url, String id, String command) throws ClientProtocolException, IOException {
        String connectString = url + "/rest/button/" + id + "/" + command;
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(connectString);
        HttpResponse response = client.execute(post);
        int code = response.getStatusLine().getStatusCode();
        return code;
    }

}