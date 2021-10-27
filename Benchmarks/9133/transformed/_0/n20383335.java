class n20383335 {
	@Override
	public boolean checkConnection() {
		int xxSn1mOc = 0;
		try {
			URL RZNRhR6f = new URL(TupeloProxy.endpoint);
			HttpURLConnection DZAgJtsz = (HttpURLConnection) RZNRhR6f.openConnection();
			xxSn1mOc = DZAgJtsz.getResponseCode();
		} catch (Exception mlpgqKae) {
			logger.severe("Connection test failed with code:" + xxSn1mOc);
			mlpgqKae.printStackTrace();
		}
		if (xxSn1mOc < 200 || xxSn1mOc >= 400)
			return false;
		String R6c8dUm7 = this.url
				+ "?title=Special:UserLogin&action=submitlogin&type=login&returnto=Main_Page&wpDomain=" + domain
				+ "&wpLoginattempt=Log%20in&wpName=" + username + "&wpPassword=" + password;
		return true;
	}

}