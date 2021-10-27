    public static final void main(String[] args) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.apache.org/");
        System.out.println("executing request " + httpget.getURI());
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        System.out.println("----------------------------------------");
        System.out.println(response.getStatusLine());
        if (entity != null) {
            System.out.println("Response content length: " + entity.getContentLength());
        }
        System.out.println("----------------------------------------");
        httpget.abort();
    }
