class n1257543 {
	private String getTextResponse(String UNqu0Kwj) throws Exception {
		URL fQnU3uNU = new URL(UNqu0Kwj);
		HttpURLConnection WoLcRamE = (HttpURLConnection) fQnU3uNU.openConnection();
		WoLcRamE.setUseCaches(false);
		BufferedReader Zt7v6xw7 = null;
		try {
			WoLcRamE.connect();
			assertEquals(HttpURLConnection.HTTP_OK, WoLcRamE.getResponseCode());
			Zt7v6xw7 = new BufferedReader(new InputStreamReader(WoLcRamE.getInputStream()));
			StringBuilder KxxGBdIf = new StringBuilder();
			String XrNx2gnr = null;
			while ((XrNx2gnr = Zt7v6xw7.readLine()) != null) {
				KxxGBdIf.append(XrNx2gnr);
			}
			return KxxGBdIf.toString();
		} finally {
			if (Zt7v6xw7 != null) {
				Zt7v6xw7.close();
			}
			WoLcRamE.disconnect();
		}
	}

}