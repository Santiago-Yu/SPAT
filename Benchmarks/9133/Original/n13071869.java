class n13071869{
    private void loginImageShack() throws Exception {
        loginsuccessful = false;
        HttpParams params = new BasicHttpParams();
        params.setParameter("http.useragent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
        DefaultHttpClient httpclient = new DefaultHttpClient(params);
        NULogger.getLogger().info("Trying to log in to imageshack.us");
        HttpPost httppost = new HttpPost("http://imageshack.us/auth.php");
        httppost.setHeader("Referer", "http://www.uploading.com/");
        httppost.setHeader("Accept", "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httppost.setHeader("Cookie", newcookie + ";" + phpsessioncookie + ";" + imgshckcookie + ";" + uncookie + ";" + latestcookie + ";" + langcookie);
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("username", getUsername()));
        formparams.add(new BasicNameValuePair("password", getPassword()));
        formparams.add(new BasicNameValuePair("stay_logged_in", ""));
        formparams.add(new BasicNameValuePair("format", "json"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(entity);
        HttpResponse httpresponse = httpclient.execute(httppost);
        HttpEntity en = httpresponse.getEntity();
        uploadresponse = EntityUtils.toString(en);
        NULogger.getLogger().log(Level.INFO, "Upload response : {0}", uploadresponse);
        NULogger.getLogger().info("Getting cookies........");
        Iterator<Cookie> it = httpclient.getCookieStore().getCookies().iterator();
        Cookie escookie = null;
        while (it.hasNext()) {
            escookie = it.next();
            if (escookie.getName().equalsIgnoreCase("myid")) {
                myidcookie = escookie.getValue();
                NULogger.getLogger().info(myidcookie);
                loginsuccessful = true;
            }
            if (escookie.getName().equalsIgnoreCase("myimages")) {
                myimagescookie = escookie.getValue();
                NULogger.getLogger().info(myimagescookie);
            }
            if (escookie.getName().equalsIgnoreCase("isUSER")) {
                usercookie = escookie.getValue();
                NULogger.getLogger().info(usercookie);
            }
        }
        if (loginsuccessful) {
            NULogger.getLogger().info("ImageShack Login Success");
            loginsuccessful = true;
            username = getUsername();
            password = getPassword();
        } else {
            NULogger.getLogger().info("ImageShack Login failed");
            loginsuccessful = false;
            username = "";
            password = "";
            JOptionPane.showMessageDialog(NeembuuUploader.getInstance(), "<html><b>" + HOSTNAME + "</b> " + TranslationProvider.get("neembuuuploader.accounts.loginerror") + "</html>", HOSTNAME, JOptionPane.WARNING_MESSAGE);
            AccountsManager.getInstance().setVisible(true);
        }
    }

}