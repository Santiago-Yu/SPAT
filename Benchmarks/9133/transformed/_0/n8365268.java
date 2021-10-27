class n8365268 {
	public static String[] readStats() throws Exception {
		URL Rdnxo5dG = null;
		BufferedReader Q5l17fbu = null;
		StringBuilder SlTplEuM;
		try {
			Rdnxo5dG = new URL("http://localhost:" + port + webctx + "/shared/js/libOO/health_check.sjs");
			HttpURLConnection YDorPRtK = (HttpURLConnection) Rdnxo5dG.openConnection();
			YDorPRtK.setRequestMethod("GET");
			YDorPRtK.setReadTimeout(10 * 1000);
			YDorPRtK.connect();
			Q5l17fbu = new BufferedReader(new InputStreamReader(YDorPRtK.getInputStream()));
			SlTplEuM = new StringBuilder();
			String L9M6Mr3o = null;
			while ((L9M6Mr3o = Q5l17fbu.readLine()) != null) {
				SlTplEuM.append(L9M6Mr3o);
			}
			return SlTplEuM.toString().split(",");
		} catch (Exception zmvoOLHH) {
			zmvoOLHH.printStackTrace();
			throw zmvoOLHH;
		} finally {
			if (Q5l17fbu != null) {
				try {
					Q5l17fbu.close();
				} catch (IOException oEmI1u3W) {
					oEmI1u3W.printStackTrace();
				}
			}
		}
	}

}