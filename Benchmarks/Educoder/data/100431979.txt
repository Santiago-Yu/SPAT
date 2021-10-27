    public String httpToStringStupid(String url) throws IllegalStateException, IOException, HttpException, InterruptedException, URISyntaxException {
        String pageDump = null;
        getParams().setParameter(ClientPNames.COOKIE_POLICY, org.apache.http.client.params.CookiePolicy.BROWSER_COMPATIBILITY);
        getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getPreferenceService().getSearchSocketTimeout());
        HttpGet httpget = new HttpGet(url);
        httpget.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getPreferenceService().getSearchSocketTimeout());
        HttpResponse response = execute(httpget);
        HttpEntity entity = response.getEntity();
        pageDump = IOUtils.toString(entity.getContent(), "UTF-8");
        return pageDump;
    }
