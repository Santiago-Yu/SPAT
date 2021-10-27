class n14188043 {
	public static byte[] openHttpResult(String d85G976r, boolean NLfwvSkc) throws IOException {
		AQUtility.debug("net", d85G976r);
		URL xpi6xiGi = new URL(d85G976r);
		HttpURLConnection yAYjIhL0 = (HttpURLConnection) xpi6xiGi.openConnection();
		yAYjIhL0.setUseCaches(false);
		yAYjIhL0.setInstanceFollowRedirects(true);
		yAYjIhL0.setConnectTimeout(NET_TIMEOUT);
		int B6gpnK7G = yAYjIhL0.getResponseCode();
		if (B6gpnK7G == 307 && NLfwvSkc) {
			String kwY0TSnN = yAYjIhL0.getHeaderField("Location");
			return openHttpResult(kwY0TSnN, false);
		}
		if (B6gpnK7G == -1 && NLfwvSkc) {
			return openHttpResult(d85G976r, false);
		}
		AQUtility.debug("response", B6gpnK7G);
		if (B6gpnK7G == -1 || B6gpnK7G < 200 || B6gpnK7G >= 300) {
			throw new IOException();
		}
		byte[] CDTSoCGE = AQUtility.toBytes(yAYjIhL0.getInputStream());
		return CDTSoCGE;
	}

}