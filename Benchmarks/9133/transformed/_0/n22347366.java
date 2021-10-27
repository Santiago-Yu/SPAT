class n22347366 {
	private static BufferedReader createReaderConnection(String tm9egZ4Q) throws SiteNotFoundException {
		BufferedReader QR9zpylQ = null;
		try {
			URL m3ntlVrH = new URL(tm9egZ4Q);
			HttpURLConnection PE0NblmL = (HttpURLConnection) m3ntlVrH.openConnection();
			PE0NblmL.setRequestProperty("User-agent", "Mozilla/4.5");
			if (PE0NblmL.getResponseCode() != HttpURLConnection.HTTP_OK) {
				Logger.logln("Response code for url [" + tm9egZ4Q + "] was " + PE0NblmL.getResponseCode() + " ["
						+ PE0NblmL.getResponseMessage() + "]");
				throw new SiteNotFoundException(tm9egZ4Q);
			}
			QR9zpylQ = new BufferedReader(new InputStreamReader(PE0NblmL.getInputStream()));
		} catch (IOException aX8VE9P2) {
			Logger.logln("" + aX8VE9P2);
		}
		return QR9zpylQ;
	}

}