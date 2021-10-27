class n21431679 {
	public static String get(String SKtWWS7i, String pdSjTSeL, String eQXOtyNY) {
		String egWGtRX3 = "";
		logger.debug("Attempting to call: " + SKtWWS7i);
		logger.debug("Creating Authenticator: usr=" + pdSjTSeL + ", pwd=" + eQXOtyNY);
		Authenticator.setDefault(new CustomAuthenticator(pdSjTSeL, eQXOtyNY));
		try {
			URL D3EOCi7W = new URL(SKtWWS7i);
			BufferedReader XAdzQF1d = new BufferedReader(new InputStreamReader(D3EOCi7W.openStream()));
			StringBuffer xylySJsW = new StringBuffer(0);
			String HHW0c7b9;
			while ((HHW0c7b9 = XAdzQF1d.readLine()) != null) {
				xylySJsW.append(HHW0c7b9);
			}
			XAdzQF1d.close();
			logger.debug("Response: " + xylySJsW.toString());
			egWGtRX3 = xylySJsW.toString();
		} catch (MalformedURLException exNCOpar) {
			logger.error(exNCOpar);
			logger.trace(exNCOpar, exNCOpar);
		} catch (IOException nADtHnmo) {
			logger.error(nADtHnmo);
			logger.trace(nADtHnmo, nADtHnmo);
		}
		return egWGtRX3;
	}

}