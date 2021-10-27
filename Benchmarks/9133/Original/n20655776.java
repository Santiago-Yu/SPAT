class n20655776{
    public static void loginLocalhostr() throws IOException {
        HttpParams params = new BasicHttpParams();
        params.setParameter("http.useragent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
        httpclient = new DefaultHttpClient(params);
        System.out.println("Trying to log in to localhostr");
        HttpPost httppost = new HttpPost("http://localhostr.com/signin");
        httppost.setHeader("Referer", "http://www.localhostr.com/");
        httppost.setHeader("Accept", "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("username", "007007dinesh@gmail.com"));
        formparams.add(new BasicNameValuePair("password", ""));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(entity);
        HttpResponse httpresponse = httpclient.execute(httppost);
        System.out.println("Getting cookies........");
        System.out.println(httpresponse.getStatusLine());
        Iterator<Cookie> it = httpclient.getCookieStore().getCookies().iterator();
        Cookie escookie = null;
        while (it.hasNext()) {
            escookie = it.next();
            if (escookie.getName().contains("session")) {
                sessioncookie = escookie.getName() + " = " + escookie.getValue();
                System.out.println("session cookie : " + sessioncookie);
            }
        }
        if (httpresponse.getStatusLine().getStatusCode() == 302) {
            login = true;
            System.out.println("localhostr Login Success");
        } else {
            System.out.println("localhostr Login failed");
        }
        System.out.println(EntityUtils.toString(httpresponse.getEntity()));
        InputStream is = httpresponse.getEntity().getContent();
        is.close();
    }

}