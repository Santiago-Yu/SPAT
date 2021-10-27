class n13075309{
    public static void loginBayFiles() throws Exception {
        HttpParams params = new BasicHttpParams();
        params.setParameter("http.useragent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
        DefaultHttpClient httpclient = new DefaultHttpClient(params);
        System.out.println("Trying to log in to bayfiles.com");
        HttpPost httppost = new HttpPost("http://bayfiles.com/ajax_login");
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("action", "login"));
        formparams.add(new BasicNameValuePair("username", ""));
        formparams.add(new BasicNameValuePair("password", ""));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(entity);
        HttpResponse httpresponse = httpclient.execute(httppost);
        System.out.println("Getting cookies........");
        Iterator<Cookie> it = httpclient.getCookieStore().getCookies().iterator();
        Cookie escookie = null;
        while (it.hasNext()) {
            escookie = it.next();
            if (escookie.getName().equalsIgnoreCase("SESSID")) {
                sessioncookie = "SESSID=" + escookie.getValue();
                System.out.println(sessioncookie);
                login = true;
                System.out.println("BayFiles.com Login success :)");
            }
        }
        if (!login) {
            System.out.println("BayFiles.com Login failed :(");
        }
    }

}