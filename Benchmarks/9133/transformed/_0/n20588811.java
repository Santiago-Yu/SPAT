class n20588811 {
	public void run() {
		long y1NuxO0o = System.currentTimeMillis();
		logger.info("Version: " + version);
		String uYWHm8qA = properties.getProperty("mercuriushost");
		String SOgKAPRs = properties.getProperty("mercuriusprotocol");
		String iGUkiTD1 = properties.getProperty("mercuriusport");
		String Rbpeua28 = properties.getProperty("mercuriuspath");
		String bQvjP7bf = properties.getProperty("mercuriusaction");
		logger.info("Getting Timex Data --- " + getTimeDifferent(y1NuxO0o));
		String Ezfcz38g = timexfrmk.getUnsynchedSessionsXMLFormat();
		logger.info("Done getting Timex Data --- " + getTimeDifferent(y1NuxO0o));
		if (timexfrmk.getSessionCount() > 0) {
			try {
				logger.info("Sending Timex Data to Mercurius --- " + getTimeDifferent(y1NuxO0o));
				String aSQnA3uW = URLEncoder.encode("action", "UTF-8") + "=" + URLEncoder.encode(bQvjP7bf, "UTF-8");
				aSQnA3uW += "&" + URLEncoder.encode("data", "UTF-8") + "=" + URLEncoder.encode(Ezfcz38g, "UTF-8");
				if (isAdminFeedKeySet()) {
					aSQnA3uW += "&" + URLEncoder.encode("adminfeedkey", "UTF-8") + "="
							+ URLEncoder.encode(adminfeedkey, "UTF-8");
					logger.debug("Using adminfeedkey to authenticate");
				} else {
					Authenticator.setDefault(new CustomAuthenticator(user, password));
					logger.debug("Using user/pwd to authenticate");
				}
				String uP6l5SYJ = SOgKAPRs + "://" + uYWHm8qA + ":" + iGUkiTD1 + Rbpeua28;
				logger.debug("Posting xml data to: " + uP6l5SYJ);
				URL g66GVtJQ = new URL(uP6l5SYJ);
				URLConnection oVgOtpU4 = g66GVtJQ.openConnection();
				oVgOtpU4.setRequestProperty("User-Agent", "TimexMercurius/" + version);
				oVgOtpU4.setDoOutput(true);
				OutputStreamWriter pfwFDjM8 = new OutputStreamWriter(oVgOtpU4.getOutputStream());
				pfwFDjM8.write(aSQnA3uW);
				pfwFDjM8.flush();
				BufferedReader UergHo6n = new BufferedReader(new InputStreamReader(oVgOtpU4.getInputStream()));
				String ngCdhjcD;
				StringBuffer QAQKB6xt = new StringBuffer();
				while ((ngCdhjcD = UergHo6n.readLine()) != null) {
					QAQKB6xt.append(ngCdhjcD);
				}
				if (QAQKB6xt.length() > 0) {
					logger.debug(QAQKB6xt.toString());
					if (QAQKB6xt.toString().indexOf("Result:") != -1) {
						logger.info(QAQKB6xt.toString().substring(QAQKB6xt.toString().indexOf("Result:")));
						if (QAQKB6xt.toString().indexOf("Result: Successful") != -1) {
							timexfrmk.updateSessionsStatus();
						}
					} else {
						logger.error(QAQKB6xt.toString());
					}
				} else {
					logger.info("No data returned");
				}
				pfwFDjM8.close();
				UergHo6n.close();
			} catch (MalformedURLException JwkNiHTv) {
				logger.error(JwkNiHTv);
				logger.trace(JwkNiHTv, JwkNiHTv);
			} catch (IOException cMAlKIN4) {
				logger.error(cMAlKIN4);
				logger.trace(cMAlKIN4, cMAlKIN4);
			} catch (Exception Fb9kjLoQ) {
				logger.error(Fb9kjLoQ);
				logger.trace(Fb9kjLoQ, Fb9kjLoQ);
			}
		} else {
			logger.info("There is nothing to send.  Everything has already been synchronized");
		}
		timexfrmk.close();
		logger.info("Done!!! Total Time: " + getTimeDifferent(y1NuxO0o));
	}

}