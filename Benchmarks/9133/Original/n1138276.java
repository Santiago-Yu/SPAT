class n1138276{
    private void login() throws LoginException {
        log.info("# i¥â©`¥É.net¤Ë¥í¥°¥¤¥ó");
        try {
            this.httpClient.getCookieStore().clear();
            HttpPost post = new HttpPost(LoginUrl);
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("HIDEURL", "?WM_AK=https%3a%2f%2fimode.net%2fag&path=%2fimail%2ftop&query="));
            formparams.add(new BasicNameValuePair("LOGIN", "WM_LOGIN"));
            formparams.add(new BasicNameValuePair("WM_KEY", "0"));
            formparams.add(new BasicNameValuePair("MDCM_UID", this.name));
            formparams.add(new BasicNameValuePair("MDCM_PWD", this.pass));
            UrlEncodedFormEntity entity = null;
            try {
                entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            } catch (Exception e) {
            }
            post.setHeader("User-Agent", "Mozilla/4.0 (compatible;MSIE 7.0; Windows NT 6.0;)");
            post.setEntity(entity);
            try {
                HttpResponse res = this.executeHttp(post);
                if (res == null) {
                    this.logined = Boolean.FALSE;
                    throw new IOException("Redirect Error");
                }
                if (res.getStatusLine().getStatusCode() != 200) {
                    this.logined = Boolean.FALSE;
                    throw new IOException("http login response bad status code " + res.getStatusLine().getStatusCode());
                }
                String body = toStringBody(res);
                if (body.indexOf("<title>ÕJÔ^¥¨¥é©`") > 0) {
                    this.logined = Boolean.FALSE;
                    log.info("ÕJÔ^¥¨¥é©`");
                    log.debug(body);
                    this.clearCookie();
                    throw new LoginException("ÕJÔ^¥¨¥é©`");
                }
            } finally {
                post.abort();
            }
            post = new HttpPost(JsonUrl + "login");
            try {
                HttpResponse res = this.requestPost(post, null);
                if (res == null) {
                    this.logined = Boolean.FALSE;
                    throw new IOException("Login Error");
                }
                if (res.getStatusLine().getStatusCode() != 200) {
                    this.logined = Boolean.FALSE;
                    throw new IOException("http login2 response bad status code " + res.getStatusLine().getStatusCode());
                }
                this.logined = Boolean.TRUE;
            } finally {
                post.abort();
            }
        } catch (Exception e) {
            this.logined = Boolean.FALSE;
            throw new LoginException("Docomo i mode.net Login Error.", e);
        }
    }

}