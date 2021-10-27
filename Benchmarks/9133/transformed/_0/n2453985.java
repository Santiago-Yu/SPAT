class n2453985 {
	@Override
	public void login() {
		loginsuccessful = false;
		try {
			HttpParams UEyWqXpk = new BasicHttpParams();
			UEyWqXpk.setParameter("http.useragent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
			DefaultHttpClient BlaQeG36 = new DefaultHttpClient(UEyWqXpk);
			NULogger.getLogger().info("Trying to log in to HotFile");
			HttpPost j5lOdD2t = new HttpPost("http://www.hotfile.com/login.php");
			j5lOdD2t.setHeader("Referer", "http://www.hotfile.com/");
			j5lOdD2t.setHeader("Cache-Control", "max-age=0");
			j5lOdD2t.setHeader("Origin", "http://www.hotfile.com/");
			j5lOdD2t.setHeader("Accept",
					"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
			List<NameValuePair> Xix3th6x = new ArrayList<NameValuePair>();
			Xix3th6x.add(new BasicNameValuePair("returnto", "%2F"));
			Xix3th6x.add(new BasicNameValuePair("user", getUsername()));
			Xix3th6x.add(new BasicNameValuePair("pass", getPassword()));
			UrlEncodedFormEntity zEHDW457 = new UrlEncodedFormEntity(Xix3th6x, "UTF-8");
			j5lOdD2t.setEntity(zEHDW457);
			HttpResponse iNBRXmkQ = BlaQeG36.execute(j5lOdD2t);
			if (iNBRXmkQ.getFirstHeader("Set-Cookie") == null) {
				NULogger.getLogger().info("HotFile Login not successful");
				loginsuccessful = false;
				username = "";
				password = "";
				JOptionPane.showMessageDialog(NeembuuUploader.getInstance(),
						"<html><b>" + HOSTNAME + "</b> "
								+ TranslationProvider.get("neembuuuploader.accounts.loginerror") + "</html>",
						HOSTNAME, JOptionPane.WARNING_MESSAGE);
				AccountsManager.getInstance().setVisible(true);
			} else {
				Iterator<Cookie> DKsQAqwN = BlaQeG36.getCookieStore().getCookies().iterator();
				while (DKsQAqwN.hasNext()) {
					hfcookie = DKsQAqwN.next();
					if (hfcookie.getName().equals("auth")) {
						NULogger.getLogger().log(Level.INFO, "hotfile login successful auth:{0}", hfcookie.getValue());
						loginsuccessful = true;
						HostsPanel.getInstance().hotFileCheckBox.setEnabled(true);
						username = getUsername();
						password = getPassword();
						break;
					}
				}
			}
		} catch (Exception ho7vCZJ6) {
			NULogger.getLogger().log(Level.SEVERE, "{0}: Error in Hotfile Login", getClass().getName());
		}
	}

}