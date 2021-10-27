class n9496557 {
	public static HttpURLConnection create(URL H1EUe2di, String xiexHySW, String CVQPQELG, HTTPRequestInfo UGHVhZjE)
			throws IOException {
		HttpURLConnection NwRrHj7J = (HttpURLConnection) H1EUe2di.openConnection();
		NwRrHj7J.setRequestMethod("POST");
		if (xiexHySW != null) {
			NwRrHj7J.setRequestProperty("id", xiexHySW);
		}
		NwRrHj7J.setRequestProperty("action", CVQPQELG);
		NwRrHj7J.setUseCaches(false);
		if (UGHVhZjE.getProxyUser() != null && UGHVhZjE.getProxyPassword() != null) {
			String XysHIKWP = UGHVhZjE.getProxyUser() + ":" + UGHVhZjE.getProxyPassword();
			String qhlSlf9c = new String(Base64.encodeBase64(XysHIKWP.getBytes()));
			NwRrHj7J.setRequestProperty("Proxy-Authorization", "Basic " + qhlSlf9c);
		}
		return NwRrHj7J;
	}

}