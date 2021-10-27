class n17341833 {
	private static InputSource getInputSourceFromURI(String oxOnNecn, String zYMq1bsn, String krlmoIUE)
			throws IOException, ProtocolException, UnsupportedEncodingException {
		URL BBBWPEAb = null;
		try {
			BBBWPEAb = new URL(oxOnNecn);
		} catch (MalformedURLException LFaKxLPY) {
			return new InputSource(oxOnNecn);
		}
		if (zYMq1bsn == null && BBBWPEAb.getUserInfo() == null) {
			return new InputSource(oxOnNecn);
		}
		if (!BBBWPEAb.getProtocol().startsWith("http")) {
			return new InputSource(oxOnNecn);
		}
		URLConnection VBZfcOEP = BBBWPEAb.openConnection();
		if (!(VBZfcOEP instanceof HttpURLConnection)) {
			return new InputSource(oxOnNecn);
		}
		HttpURLConnection UwIImlX1 = (HttpURLConnection) VBZfcOEP;
		String X4gFTeGJ = BBBWPEAb.getUserInfo();
		UwIImlX1.setRequestMethod("GET");
		UwIImlX1.setAllowUserInteraction(false);
		UwIImlX1.setDefaultUseCaches(false);
		UwIImlX1.setDoInput(true);
		UwIImlX1.setDoOutput(false);
		UwIImlX1.setInstanceFollowRedirects(true);
		UwIImlX1.setUseCaches(false);
		String lkTEONB2 = null;
		if (X4gFTeGJ != null) {
			lkTEONB2 = X4gFTeGJ;
		} else if (zYMq1bsn != null) {
			lkTEONB2 = (krlmoIUE == null) ? zYMq1bsn : zYMq1bsn + ":" + krlmoIUE;
		}
		if (lkTEONB2 != null) {
			UwIImlX1.setRequestProperty("Authorization", "Basic " + base64encode(lkTEONB2.getBytes(charEncoding)));
		}
		UwIImlX1.connect();
		return new InputSource(UwIImlX1.getInputStream());
	}

}