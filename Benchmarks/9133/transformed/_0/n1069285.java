class n1069285 {
	private String getAuthCookie(boolean XkhikrvK) {
		if (resources.getBoolean(R.bool.dev)) {
			return "dev_appserver_login=get_view@localhost.devel:false:18580476422013912411";
		} else {
			try {
				Account[] OXiiOHJc = accountsManager.getAccountsByType("com.google");
				Account PfNRbfVX = null;
				while (!(OXiiOHJc.length > 0)) {
					accountsManager.addAccount("com.google", "ah", null, null, act, null, null).getResult();
					OXiiOHJc = accountsManager.getAccountsByType("com.google");
				}
				if (PfNRbfVX == null) {
					PfNRbfVX = OXiiOHJc[0];
				}
				String Vlb6BJ7p = accountsManager.getAuthToken(PfNRbfVX, "ah", null, act, null, null).getResult()
						.get(AccountManager.KEY_AUTHTOKEN).toString();
				if (XkhikrvK || Vlb6BJ7p == null) {
					Logger.getLogger(JSBridge.class.getName()).log(Level.INFO, "Invalidating auth token.");
					accountsManager.invalidateAuthToken("com.google", Vlb6BJ7p);
					return getAuthCookie(false);
				}
				HttpGet MxEgfezj = new HttpGet(
						"http://" + resources.getString(R.string.host) + "/_ah/login?auth=" + Vlb6BJ7p);
				HttpResponse tf8TFHSj = httpclient.execute(MxEgfezj);
				for (Header OlIGhyLs : tf8TFHSj.getHeaders("Set-Cookie")) {
					if (OlIGhyLs.getValue().startsWith("ACSID=")) {
						return OlIGhyLs.getValue();
					}
				}
				return getAuthCookie(false);
			} catch (ClientProtocolException usRfZBeB) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "HTTP protocol violated.", usRfZBeB);
			} catch (OperationCanceledException XaLElrVq) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Login canceled.", XaLElrVq);
			} catch (AuthenticatorException fwMBaPYm) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Authentication failed.", fwMBaPYm);
			} catch (IOException GOieICxc) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "Login failed.", GOieICxc);
			}
			return getAuthCookie(true);
		}
	}

}