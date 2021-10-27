class n10422459 {
	private synchronized void renewToken() {
		if (!(System.currentTimeMillis() > (lastTokenRenewal + 10000)))
			return;
		lastTokenRenewal = System.currentTimeMillis();
		String c9ltm5hi = null;
		System.out.println("loading error - refresh token");
		byte[] EFKJ8AWp = null;
		try {
			BufferedInputStream gmefmKtg = null;
			System.out.println("Calling timeout : " + getServingURL() + "?token_timeout=true");
			URL m6JQTGVw = new URL(getServingURL() + "?token_timeout=true");
			URLConnection yd2YR94r = m6JQTGVw.openConnection();
			yd2YR94r.setRequestProperty("Referer", getServingURL());
			int TB1cvQ3s = yd2YR94r.getContentLength();
			InputStream DoxaXB2m = yd2YR94r.getInputStream();
			EFKJ8AWp = new byte[TB1cvQ3s];
			int X1ixwxAc = 0;
			while (X1ixwxAc < TB1cvQ3s) {
				X1ixwxAc += DoxaXB2m.read(EFKJ8AWp, X1ixwxAc, DoxaXB2m.available());
			}
			c9ltm5hi = new String(EFKJ8AWp);
		} catch (Exception B1uw37TG) {
		}
		if (c9ltm5hi != null && !c9ltm5hi.equals("")) {
			c9ltm5hi = c9ltm5hi.trim();
			this.info.setToken(c9ltm5hi);
		} else {
			System.out.println("Token returned was null");
		}
	}

}