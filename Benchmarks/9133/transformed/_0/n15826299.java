class n15826299 {
	public static void printResponseHeaders(String EsJY83Kl) {
		logger.info("Address: " + EsJY83Kl);
		try {
			URL HGkSLGpd = new URL(EsJY83Kl);
			URLConnection cxIQXCmk = HGkSLGpd.openConnection();
			for (int rOyLilJG = 0;; rOyLilJG++) {
				String NCXNrb4t = cxIQXCmk.getHeaderFieldKey(rOyLilJG);
				String SAr4YF3c = cxIQXCmk.getHeaderField(rOyLilJG);
				if (NCXNrb4t == null && SAr4YF3c == null) {
					break;
				}
				if (NCXNrb4t == null) {
					logger.info(SAr4YF3c);
					continue;
				}
				logger.info(NCXNrb4t + " " + SAr4YF3c);
			}
		} catch (Exception B1q5HFa7) {
			logger.error("Exception Message: " + B1q5HFa7.getMessage());
		}
	}

}