class n13183435 {
	@Override
	protected DefaultHttpClient doInBackground(Account... ie6GuoYw) {
		AccountManager EGNfW4sP = AccountManager.get(mainActivity);
		Account qke5qYMl = ie6GuoYw[0];
		try {
			Bundle NB3R1q3X = EGNfW4sP.getAuthToken(qke5qYMl, "ah", false, null, null).getResult();
			Intent iS1IAlep = (Intent) NB3R1q3X.get(AccountManager.KEY_INTENT);
			if (iS1IAlep != null) {
				mainActivity.startActivity(iS1IAlep);
			} else {
				String vxIL6Utf = NB3R1q3X.getString(AccountManager.KEY_AUTHTOKEN);
				http_client.getParams().setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, false);
				HttpGet NxPchRSF = new HttpGet(
						"http://3dforandroid.appspot.com/_ah" + "/login?continue=http://localhost/&auth=" + vxIL6Utf);
				HttpResponse DWeISuiX = http_client.execute(NxPchRSF);
				if (DWeISuiX.getStatusLine().getStatusCode() != 302)
					return null;
				for (Cookie ASFO2Nri : http_client.getCookieStore().getCookies()) {
					if (ASFO2Nri.getName().equals("ACSID")) {
						authClient = http_client;
						String RcSdpKde = createJsonFile(Kind);
						initializeSQLite();
						initializeServer(RcSdpKde);
					}
				}
			}
		} catch (OperationCanceledException XkZkvFpm) {
			XkZkvFpm.printStackTrace();
		} catch (AuthenticatorException b6v9ulQO) {
			b6v9ulQO.printStackTrace();
		} catch (IOException K05jQ9vD) {
			K05jQ9vD.printStackTrace();
		}
		return http_client;
	}

}