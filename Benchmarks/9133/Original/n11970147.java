class n11970147{
    public String httpToStringStupid(String url) throws IllegalStateException, IOException, HttpException, InterruptedException, URISyntaxException {
        LOG.info("Loading URL: " + url);
        String pageDump = null;
        getParams().setParameter(ClientPNames.COOKIE_POLICY, org.apache.http.client.params.CookiePolicy.BROWSER_COMPATIBILITY);
        getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getSocketTimeout());
        HttpGet httpget = new HttpGet(url);
        httpget.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getSocketTimeout());
        HttpResponse response = execute(httpget);
        HttpEntity entity = response.getEntity();
        pageDump = IOUtils.toString(entity.getContent(), "UTF-8");
        return pageDump;
    }

}