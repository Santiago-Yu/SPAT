class n22842674 {
	private byte[] getImage(String HtmI3h2G) throws Exception {
		URL WrIuvH5H = new URL(HtmI3h2G);
		HttpURLConnection W3iZord7 = (HttpURLConnection) WrIuvH5H.openConnection();
		W3iZord7.setRequestMethod("GET");
		W3iZord7.setConnectTimeout(6 * 1000);
		if (W3iZord7.getResponseCode() == 200) {
			InputStream q5nTZ4Qf = W3iZord7.getInputStream();
			return readStream(q5nTZ4Qf);
		}
		return null;
	}

}