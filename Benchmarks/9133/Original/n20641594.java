class n20641594{
    public static InputStream getInputStreamFromUrl(String url) {
        InputStream content = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httpGet);
            content = response.getEntity().getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

}