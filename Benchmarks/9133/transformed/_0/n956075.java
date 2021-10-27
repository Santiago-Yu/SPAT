class n956075 {
	public void loginSendSpace() throws Exception {
		loginsuccessful = false;
		HttpParams w2rQ7MK8 = new BasicHttpParams();
		w2rQ7MK8.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient ll13TLkN = new DefaultHttpClient(w2rQ7MK8);
		NULogger.getLogger().info("Trying to log in to sendspace");
		HttpPost UdPCKjhd = new HttpPost("http://www.sendspace.com/login.html");
		UdPCKjhd.setHeader("Cookie", sidcookie + ";" + ssuicookie);
		List<NameValuePair> l6pzG5FY = new ArrayList<NameValuePair>();
		l6pzG5FY.add(new BasicNameValuePair("action", "login"));
		l6pzG5FY.add(new BasicNameValuePair("submit", "login"));
		l6pzG5FY.add(new BasicNameValuePair("target", "%252F"));
		l6pzG5FY.add(new BasicNameValuePair("action_type", "login"));
		l6pzG5FY.add(new BasicNameValuePair("remember", "1"));
		l6pzG5FY.add(new BasicNameValuePair("username", getUsername()));
		l6pzG5FY.add(new BasicNameValuePair("password", getPassword()));
		UrlEncodedFormEntity B4GvfPdi = new UrlEncodedFormEntity(l6pzG5FY, "UTF-8");
		UdPCKjhd.setEntity(B4GvfPdi);
		HttpResponse v1ObIKTr = ll13TLkN.execute(UdPCKjhd);
		NULogger.getLogger().info("Getting cookies........");
		Iterator<Cookie> wtsOugqz = ll13TLkN.getCookieStore().getCookies().iterator();
		Cookie e4LXPhUX = null;
		while (wtsOugqz.hasNext()) {
			e4LXPhUX = wtsOugqz.next();
			if (e4LXPhUX.getName().equalsIgnoreCase("ssal")) {
				ssalcookie = e4LXPhUX.getName() + "=" + e4LXPhUX.getValue();
				NULogger.getLogger().info(ssalcookie);
				loginsuccessful = true;
			}
		}
		if (loginsuccessful) {
			username = getUsername();
			password = getPassword();
			NULogger.getLogger().info("SendSpace login success :)");
		} else {
			NULogger.getLogger().info("SendSpace login failed :(");
			loginsuccessful = false;
			username = "";
			password = "";
			JOptionPane.showMessageDialog(
					NeembuuUploader.getInstance(), "<html><b>" + HOSTNAME + "</b> "
							+ TranslationProvider.get("neembuuuploader.accounts.loginerror") + "</html>",
					HOSTNAME, JOptionPane.WARNING_MESSAGE);
			AccountsManager.getInstance().setVisible(true);
		}
	}

}