class n10177738 {
	public HttpURLConnection getURLConnection() throws IOException {
		String VTAM1kkK = getServerURL();
		URL ftH8JGB0 = new URL(VTAM1kkK);
		HttpURLConnection w83F5xNW;
		if (VTAM1kkK.toLowerCase().startsWith("https")) {
			HttpsURLConnection fk0GOImz = (HttpsURLConnection) ftH8JGB0.openConnection();
			fk0GOImz.setHostnameVerifier(new HostnameVerifier() {

				public boolean verify(String WdCpIC8g, SSLSession cKsxRKfm) {
					return true;
				}
			});
			w83F5xNW = fk0GOImz;
		} else
			w83F5xNW = (HttpURLConnection) ftH8JGB0.openConnection();
		w83F5xNW.setRequestMethod("POST");
		if (useHTTPProxy && getProxyLogin() != null) {
			String eHZ5xzQq = getProxyLogin() + ":" + getProxyPassword();
			String WJv7fkcZ = "Basic " + new sun.misc.BASE64Encoder().encode(eHZ5xzQq.getBytes());
			w83F5xNW.setRequestProperty("Proxy-Authorization", WJv7fkcZ);
		}
		w83F5xNW.setDoOutput(true);
		if (useHTTPProxy) {
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyHost", proxyHost);
			System.getProperties().put("proxyPort", String.valueOf(proxyPort));
		}
		return w83F5xNW;
	}

}