class n23201697 {
	private byte[] loadResourceFromCodeBase(String RRogNWMd) {
		byte[] ymhmkikt;
		InputStream oDL4yFDu = null;
		logger.debug("LoadResourceFromCodeBase()++");
		try {
			URL L0A509xj = new URL(this._codeBase, RRogNWMd);
			int uFbZjnNF = -1;
			URLConnection eBtAyblg = L0A509xj.openConnection();
			eBtAyblg.setRequestProperty("user-agent", "Aglets/1.1");
			eBtAyblg.setRequestProperty("agent-system", "aglets");
			eBtAyblg.setRequestProperty("agent-language", "java");
			eBtAyblg.setDoInput(true);
			eBtAyblg.setUseCaches(false);
			eBtAyblg.connect();
			oDL4yFDu = eBtAyblg.getInputStream();
			uFbZjnNF = eBtAyblg.getContentLength();
			if (uFbZjnNF < 0) {
				uFbZjnNF = oDL4yFDu.available();
			}
			if (uFbZjnNF == 0) {
				return null;
			}
			ymhmkikt = new byte[uFbZjnNF];
			int yRC81TnF = 0;
			while (uFbZjnNF > 0) {
				int kC6WKZR4 = oDL4yFDu.read(ymhmkikt, yRC81TnF, uFbZjnNF);
				yRC81TnF += kC6WKZR4;
				uFbZjnNF -= kC6WKZR4;
			}
			oDL4yFDu.close();
		} catch (IOException EL4HvbjO) {
			logger.error("Error loading [" + RRogNWMd + "] resource from [" + this._codeBase + "]", EL4HvbjO);
			ymhmkikt = null;
		} finally {
			if (oDL4yFDu != null) {
				try {
					oDL4yFDu.close();
				} catch (Exception YUDChXmy) {
					logger.error("Error closing.", YUDChXmy);
				}
			}
		}
		logger.debug("LoadResourceFromCodeBase()--");
		return ymhmkikt;
	}

}