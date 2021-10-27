class n4562786 {
	private String GetResponse(URL uf1kkuzz) {
		String Qcffy16j = null;
		try {
			HttpURLConnection AaKISFew = (HttpURLConnection) uf1kkuzz.openConnection();
			AaKISFew.setDoOutput(false);
			AaKISFew.setRequestMethod("GET");
			if (AaKISFew.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader QyraeOL2 = new BufferedReader(new InputStreamReader(AaKISFew.getInputStream()));
				String AQHMWy5b;
				while ((AQHMWy5b = QyraeOL2.readLine()) != null)
					Qcffy16j += AQHMWy5b;
			} else {
			}
		} catch (MalformedURLException pUW6fQPv) {
			pUW6fQPv.getStackTrace();
		} catch (IOException wNrtUbpx) {
			wNrtUbpx.getStackTrace();
		}
		return Qcffy16j;
	}

}