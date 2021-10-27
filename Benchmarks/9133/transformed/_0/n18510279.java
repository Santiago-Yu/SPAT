class n18510279 {
	public void login() {
		loginsuccessful = false;
		try {
			cookies = new StringBuilder();
			HttpParams iJR5RPIR = new BasicHttpParams();
			iJR5RPIR.setParameter("http.useragent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
			DefaultHttpClient yrEAFxs0 = new DefaultHttpClient(iJR5RPIR);
			NULogger.getLogger().info("Trying to log in to crocko.com");
			HttpPost KGsbHzrc = new HttpPost("https://www.crocko.com/accounts/login");
			List<NameValuePair> SN8n2uRX = new ArrayList<NameValuePair>();
			SN8n2uRX.add(new BasicNameValuePair("login", getUsername()));
			SN8n2uRX.add(new BasicNameValuePair("password", getPassword()));
			UrlEncodedFormEntity hf3h39rb = new UrlEncodedFormEntity(SN8n2uRX, "UTF-8");
			KGsbHzrc.setEntity(hf3h39rb);
			HttpResponse CkTmpgWr = yrEAFxs0.execute(KGsbHzrc);
			NULogger.getLogger().info("Getting cookies........");
			NULogger.getLogger().info(EntityUtils.toString(CkTmpgWr.getEntity()));
			Iterator<Cookie> yXdTJiXK = yrEAFxs0.getCookieStore().getCookies().iterator();
			Cookie fE4Y0DsM = null;
			while (yXdTJiXK.hasNext()) {
				fE4Y0DsM = yXdTJiXK.next();
				cookies.append(fE4Y0DsM.getName()).append("=").append(fE4Y0DsM.getValue()).append(";");
				if (fE4Y0DsM.getName().equals("PHPSESSID")) {
					sessionid = fE4Y0DsM.getValue();
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
			yrEAFxs0.getConnectionManager().shutdown();
		} catch (Exception NYgg26U7) {
			NULogger.getLogger().log(Level.SEVERE, "{0}: {1}",
					new Object[] { getClass().getName(), NYgg26U7.toString() });
			System.err.println(NYgg26U7);
		}
	}

}