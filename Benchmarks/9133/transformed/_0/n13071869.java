class n13071869 {
	private void loginImageShack() throws Exception {
		loginsuccessful = false;
		HttpParams gsXW9Rnp = new BasicHttpParams();
		gsXW9Rnp.setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		DefaultHttpClient jdOkTg8m = new DefaultHttpClient(gsXW9Rnp);
		NULogger.getLogger().info("Trying to log in to imageshack.us");
		HttpPost i6acjNnl = new HttpPost("http://imageshack.us/auth.php");
		i6acjNnl.setHeader("Referer", "http://www.uploading.com/");
		i6acjNnl.setHeader("Accept",
				"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		i6acjNnl.setHeader("Cookie", newcookie + ";" + phpsessioncookie + ";" + imgshckcookie + ";" + uncookie + ";"
				+ latestcookie + ";" + langcookie);
		List<NameValuePair> ed8xmPxJ = new ArrayList<NameValuePair>();
		ed8xmPxJ.add(new BasicNameValuePair("username", getUsername()));
		ed8xmPxJ.add(new BasicNameValuePair("password", getPassword()));
		ed8xmPxJ.add(new BasicNameValuePair("stay_logged_in", ""));
		ed8xmPxJ.add(new BasicNameValuePair("format", "json"));
		UrlEncodedFormEntity S9rjS6Xx = new UrlEncodedFormEntity(ed8xmPxJ, "UTF-8");
		i6acjNnl.setEntity(S9rjS6Xx);
		HttpResponse v1lbGct2 = jdOkTg8m.execute(i6acjNnl);
		HttpEntity SRHVs5pG = v1lbGct2.getEntity();
		uploadresponse = EntityUtils.toString(SRHVs5pG);
		NULogger.getLogger().log(Level.INFO, "Upload response : {0}", uploadresponse);
		NULogger.getLogger().info("Getting cookies........");
		Iterator<Cookie> p7UG1N6X = jdOkTg8m.getCookieStore().getCookies().iterator();
		Cookie yAjBTSSa = null;
		while (p7UG1N6X.hasNext()) {
			yAjBTSSa = p7UG1N6X.next();
			if (yAjBTSSa.getName().equalsIgnoreCase("myid")) {
				myidcookie = yAjBTSSa.getValue();
				NULogger.getLogger().info(myidcookie);
				loginsuccessful = true;
			}
			if (yAjBTSSa.getName().equalsIgnoreCase("myimages")) {
				myimagescookie = yAjBTSSa.getValue();
				NULogger.getLogger().info(myimagescookie);
			}
			if (yAjBTSSa.getName().equalsIgnoreCase("isUSER")) {
				usercookie = yAjBTSSa.getValue();
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
			JOptionPane.showMessageDialog(
					NeembuuUploader.getInstance(), "<html><b>" + HOSTNAME + "</b> "
							+ TranslationProvider.get("neembuuuploader.accounts.loginerror") + "</html>",
					HOSTNAME, JOptionPane.WARNING_MESSAGE);
			AccountsManager.getInstance().setVisible(true);
		}
	}

}