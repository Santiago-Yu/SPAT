class n9593394 {
	private RatingServiceSelectionResponseType contactService(String sDfnW806) throws Exception {
		OutputStream D2aMqSXg = null;
		RatingServiceSelectionResponseType x6nOjTxA = null;
		try {
			URL X4oIjB7W = new URL(ENDPOINT_URL);
			HttpURLConnection RGsZIdl4 = (HttpURLConnection) X4oIjB7W.openConnection();
			RGsZIdl4.setDoOutput(true);
			RGsZIdl4.setDoInput(true);
			RGsZIdl4.setUseCaches(false);
			D2aMqSXg = RGsZIdl4.getOutputStream();
			D2aMqSXg.write(sDfnW806.getBytes());
			D2aMqSXg.flush();
			D2aMqSXg.close();
			x6nOjTxA = readURLConnection(RGsZIdl4);
			RGsZIdl4.disconnect();
		} catch (Exception gQd6PPQR) {
			throw gQd6PPQR;
		} finally {
			if (D2aMqSXg != null) {
				D2aMqSXg.close();
				D2aMqSXg = null;
			}
		}
		return x6nOjTxA;
	}

}