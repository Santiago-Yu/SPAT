class n18510279 {
	public void login() {
		loginsuccessful = false;
		try {
			HttpParams params = new BasicHttpParams();
			cookies = new StringBuilder();
			params.setParameter("http.useragent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
			DefaultHttpClient httpclient = new DefaultHttpClient(params);
			NULogger.getLogger().info("Trying to log in to crocko.com");
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			HttpPost httppost = new HttpPost("https://www.crocko.com/accounts/login");
			formparams.add(new BasicNameValuePair("login", getUsername()));
			formparams.add(new BasicNameValuePair("password", getPassword()));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(entity);
			HttpResponse httpresponse = httpclient.execute(httppost);
			NULogger.getLogger().info("Getting cookies........");
			NULogger.getLogger().info(EntityUtils.toString(httpresponse.getEntity()));
			Cookie escookie = null;
			Iterator<Cookie> it = httpclient.getCookieStore().getCookies().iterator();
			while (it.hasNext()) {
				escookie = it.next();
				cookies.append(escookie.getName()).append("=").append(escookie.getValue()).append(";");
				if (escookie.getName().equals("PHPSESSID")) {
					sessionid = escookie.getValue();
					NULogger.getLogger().info(sessionid);
				}
			}
			if (cookies.toString().contains("logacc")) {
				NULogger.getLogger().info(cookies.toString());
				loginsuccessful = true;
				username = getUsername();
				password = getPassword();
				NULogger.getLogger().info("Crocko login successful :)");
			}
			if (!loginsuccessful) {
				NULogger.getLogger().info("Crocko.com Login failed :(");
				loginsuccessful = false;
				username = "";
				password = "";
				JOptionPane.showMessageDialog(NeembuuUploader.getInstance(),
						"<html><b>" + HOSTNAME + "</b> "
								+ TranslationProvider.get("neembuuuploader.accounts.loginerror") + "</html>",
						HOSTNAME, JOptionPane.WARNING_MESSAGE);
				AccountsManager.getInstance().setVisible(true);
			}
			httpclient.getConnectionManager().shutdown();
		} catch (Exception e) {
			NULogger.getLogger().log(Level.SEVERE, "{0}: {1}", new Object[] { getClass().getName(), e.toString() });
			System.err.println(e);
		}
	}

}