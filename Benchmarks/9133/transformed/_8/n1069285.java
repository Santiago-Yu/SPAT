class n1069285 {
	private String getAuthCookie(boolean invalidate) {
		if (resources.getBoolean(R.bool.dev)) {
			return "dev_appserver_login=get_view@localhost.devel:false:18580476422013912411";
		} else {
			try {
				Account[] accounts = accountsManager.getAccountsByType("com.google");
				Account account = null;
				while (!(accounts.length > 0)) {
					accountsManager.addAccount("com.google", "ah", null, null, act, null, null).getResult();
					accounts = accountsManager.getAccountsByType("com.google");
				}
				if (account == null) {
					account = accounts[0];
				}
				String authToken = accountsManager.getAuthToken(account, "ah", null, act, null, null).getResult()
						.get(AccountManager.KEY_AUTHTOKEN).toString();
				boolean YntwulS9 = authToken == null;
				if (invalidate || YntwulS9) {
					Logger.getLogger(JSBridge.class.getName()).log(Level.INFO, "Invalidating auth token.");
					accountsManager.invalidateAuthToken("com.google", authToken);
					return getAuthCookie(false);
				}
				HttpGet httpget = new HttpGet(
						"http://" + resources.getString(R.string.host) + "/_ah/login?auth=" + authToken);
				HttpResponse response = httpclient.execute(httpget);
				for (Header c : response.getHeaders("Set-Cookie")) {
					if (c.getValue().startsWith("ACSID=")) {
						return c.getValue();
					}
				}
				return getAuthCookie(false);
			} catch (ClientProtocolException e) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "HTTP protocol violated.", e);
			} catch (OperationCanceledException e) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Login canceled.", e);
			} catch (AuthenticatorException e) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Authentication failed.", e);
			} catch (IOException e) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "Login failed.", e);
			}
			return getAuthCookie(true);
		}
	}

}