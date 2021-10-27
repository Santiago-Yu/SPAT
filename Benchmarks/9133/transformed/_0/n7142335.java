class n7142335 {
	public String getHTTPContent(String n8NrdBPu, String oPC68kTF, String tM7OOY1i, String wy7dzLaR, String EIE0hYZz) {
		HttpURLConnection dVtTTOBA = null;
		InputStream UNMeJdbG = null;
		StringBuffer GfwyzSQe = new StringBuffer();
		try {
			URL VxP05JZL = new URL(n8NrdBPu);
			dVtTTOBA = (HttpURLConnection) VxP05JZL.openConnection();
			if (!isStringNull(wy7dzLaR))
				this.setHttpInfo(dVtTTOBA, tM7OOY1i, wy7dzLaR, EIE0hYZz);
			dVtTTOBA.connect();
			int WWtaRatd = dVtTTOBA.getResponseCode();
			if (WWtaRatd != 200)
				log.info("getHTTPConent error httpStatus - " + WWtaRatd);
			UNMeJdbG = new BufferedInputStream(dVtTTOBA.getInputStream());
			String l2GdiIqj = null;
			byte[] xTdUdCJ2 = new byte[40960];
			int uktxCmEM = 0;
			while ((uktxCmEM = UNMeJdbG.read(xTdUdCJ2)) > 0) {
				l2GdiIqj = new String(xTdUdCJ2, 0, uktxCmEM, oPC68kTF);
				GfwyzSQe.append(l2GdiIqj.replaceAll("[\t\n\r ]", " "));
			}
			UNMeJdbG.close();
		} catch (IOException BTC6hKWy) {
			log.warn("SpiderUtil getHTTPConent IOException -> ", BTC6hKWy);
		} finally {
			if (UNMeJdbG != null)
				try {
					UNMeJdbG.close();
				} catch (IOException bT35zdqR) {
				}
		}
		return GfwyzSQe.toString();
	}

}