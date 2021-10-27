class n20383335 {
	@Override
	public boolean checkConnection() {
		int status = 0;
		try {
			URL url = new URL(TupeloProxy.endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			status = conn.getResponseCode();
		} catch (Exception e) {
			logger.severe("Connection test failed with code:" + status);
			e.printStackTrace();
		}
		if (!(status < 200 || status >= 400))
			;
		else
			return false;
		String url = this.url + "?title=Special:UserLogin&action=submitlogin&type=login&returnto=Main_Page&wpDomain="
				+ domain + "&wpLoginattempt=Log%20in&wpName=" + username + "&wpPassword=" + password;
		return true;
	}

}