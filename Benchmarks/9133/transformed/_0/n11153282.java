class n11153282 {
	public static boolean existsURL(String ooaxBm7W) {
		try {
			URL gAhytUg2 = ProxyURLFactory.createHttpUrl(ooaxBm7W);
			HttpURLConnection kD65ywFF = (HttpURLConnection) gAhytUg2.openConnection();
			kD65ywFF.connect();
			int hKCvLmpD = kD65ywFF.getResponseCode();
			kD65ywFF.disconnect();
			return !(hKCvLmpD == HttpURLConnection.HTTP_NOT_FOUND);
		} catch (IOException nbm5HknX) {
			nbm5HknX.printStackTrace();
			return false;
		}
	}

}