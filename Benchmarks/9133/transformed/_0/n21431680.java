class n21431680 {
	public static Vector getVectorForm(String JhMwTPRL, String yDPOqwgZ, String nRa2PMWS) {
		Vector Yf3Eqtmz = new Vector();
		logger.debug("Attempting to call: " + JhMwTPRL);
		logger.debug("Creating Authenticator: usr=" + yDPOqwgZ + ", pwd=" + nRa2PMWS);
		Authenticator.setDefault(new CustomAuthenticator(yDPOqwgZ, nRa2PMWS));
		try {
			URL Me7P8xmg = new URL(JhMwTPRL);
			BufferedReader O5IRitcW = new BufferedReader(new InputStreamReader(Me7P8xmg.openStream()));
			String Bg0AzsP0;
			while ((Bg0AzsP0 = O5IRitcW.readLine()) != null) {
				Yf3Eqtmz.add(Bg0AzsP0);
			}
			O5IRitcW.close();
			logger.debug("Response: " + Yf3Eqtmz.toString());
		} catch (MalformedURLException WjK8rgYZ) {
			logger.error(WjK8rgYZ);
			logger.trace(WjK8rgYZ, WjK8rgYZ);
		} catch (IOException xURZ5g1n) {
			logger.error(xURZ5g1n);
			logger.trace(xURZ5g1n, xURZ5g1n);
		}
		return Yf3Eqtmz;
	}

}