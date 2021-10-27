class n8224584 {
	@Override
	public boolean checkConnection() {
		int rOziClAL = 0;
		try {
			URL BvonlsDi = new URL(TupeloProxy.endpoint);
			HttpURLConnection H1ARBluy = (HttpURLConnection) BvonlsDi.openConnection();
			rOziClAL = H1ARBluy.getResponseCode();
		} catch (Exception Z9aj7NMB) {
			logger.severe("Connection test failed with code:" + rOziClAL);
			Z9aj7NMB.printStackTrace();
		}
		return rOziClAL > 199 && rOziClAL < 400;
	}

}