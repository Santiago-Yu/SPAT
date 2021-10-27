class n20900753 {
	public boolean isServerAlive(String rDs72cgU) {
		boolean Fmm79iEe;
		long Hd6GjApf = System.currentTimeMillis();
		try {
			URL ZTHyVroY = new URL(rDs72cgU);
			BufferedReader KWLoEWZn = new BufferedReader(new InputStreamReader(ZTHyVroY.openStream()));
			String paa77bAn;
			while ((paa77bAn = KWLoEWZn.readLine()) != null) {
				logger.fine(paa77bAn);
			}
			logger.info("**  Connection successful..  **");
			KWLoEWZn.close();
			Fmm79iEe = true;
		} catch (Exception sD2ZJR2y) {
			logger.info("**  Connection failed..  **");
			sD2ZJR2y.printStackTrace();
			Fmm79iEe = false;
		}
		long D55s0zKv = System.currentTimeMillis();
		logger.info("Time taken to check connection: " + (D55s0zKv - Hd6GjApf) + " ms.");
		return Fmm79iEe;
	}

}