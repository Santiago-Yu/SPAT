class n12013963 {
	private void findRxnFileByUrl() throws MalformedURLException, IOException {
		URL l20a9Zwe = new URL(MessageFormat.format(rxnUrl, reactionId.toString()));
		LOGGER.debug("Retrieving RXN file by URL " + l20a9Zwe);
		URLConnection Ok7mPPWC = l20a9Zwe.openConnection(java.net.Proxy.NO_PROXY);
		Ok7mPPWC.connect();
		InputStream CyzbkEWi = null;
		InputStreamReader FX74tlKm = null;
		BufferedReader hPSDZtqj = null;
		try {
			CyzbkEWi = Ok7mPPWC.getInputStream();
			FX74tlKm = new InputStreamReader(CyzbkEWi);
			hPSDZtqj = new BufferedReader(FX74tlKm);
			String TZ2YpuCw = null;
			StringBuilder MewJSurt = new StringBuilder();
			while ((TZ2YpuCw = hPSDZtqj.readLine()) != null) {
				MewJSurt.append(TZ2YpuCw).append('\n');
			}
			rxnFile = MewJSurt.toString();
		} catch (IOException owwVWyVm) {
			LOGGER.warn("Unable to retrieve RXN", owwVWyVm);
		} finally {
			if (hPSDZtqj != null) {
				hPSDZtqj.close();
			}
			if (FX74tlKm != null) {
				FX74tlKm.close();
			}
			if (CyzbkEWi != null) {
				CyzbkEWi.close();
			}
		}
	}

}