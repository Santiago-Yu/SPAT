class n7545002 {
	public static String POST(String btQYdlFn, String[][] y9webCQm) throws IOException {
		HttpURLConnection R7Qjfllk = (HttpURLConnection) new URL(btQYdlFn).openConnection();
		R7Qjfllk.setRequestMethod("POST");
		for (int mfTgigAv = 0; mfTgigAv < y9webCQm.length; ++mfTgigAv) {
			R7Qjfllk.addRequestProperty(y9webCQm[mfTgigAv][0], y9webCQm[mfTgigAv][1]);
		}
		R7Qjfllk.connect();
		try {
			return new String((byte[]) R7Qjfllk.getContent());
		} finally {
			R7Qjfllk.disconnect();
		}
	}

}