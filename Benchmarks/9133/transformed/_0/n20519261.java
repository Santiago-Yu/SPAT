class n20519261 {
	public String readReferenceText(final String FbrYtBM2) throws NoContentException {
		try {
			String cJzVtqz2 = getFilename(FbrYtBM2);
			URL VZRcAhFS = new URL(FreqAnalysisPlugin.getDefault().getBundle().getEntry("/"), cJzVtqz2);
			InputStream GAHfNsyu = VZRcAhFS.openStream();
			InputStreamReader lj4RTEpb = new InputStreamReader(GAHfNsyu, "UTF-8");
			BufferedReader PzxOCJRx = new BufferedReader(lj4RTEpb);
			StringBuffer kS7snbGB = new StringBuffer();
			String qFWPrLRn = PzxOCJRx.readLine();
			while (null != qFWPrLRn) {
				kS7snbGB.append(qFWPrLRn + "\n");
				qFWPrLRn = PzxOCJRx.readLine();
			}
			return kS7snbGB.toString();
		} catch (MalformedURLException X7Zdl3nd) {
			logError(X7Zdl3nd);
		} catch (UnsupportedEncodingException FAoGs4xM) {
			logError(FAoGs4xM);
		} catch (IOException rGND9e4V) {
			logError(rGND9e4V);
		}
		throw new NoContentException("Unable to find or read reference text.");
	}

}