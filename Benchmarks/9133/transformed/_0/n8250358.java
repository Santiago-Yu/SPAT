class n8250358 {
	private static InputStream connect(String O7I78zV0) throws IOException {
		int KxsU1PmH = 0;
		String eOA3RSag = getCurrentlyActiveServer();
		try {
			long DW2c3GM8 = System.currentTimeMillis();
			HttpURLConnection DPm7HR90 = (HttpURLConnection) new URL(eOA3RSag + O7I78zV0).openConnection();
			DPm7HR90.setConnectTimeout(connectTimeOut);
			DPm7HR90.setReadTimeout(readTimeOut);
			DPm7HR90.setRequestProperty("User-Agent", USER_AGENT);
			InputStream EkPlPEM0 = DPm7HR90.getInputStream();
			KxsU1PmH = DPm7HR90.getResponseCode();
			if (KxsU1PmH == 200) {
				long LEEkDVXh = System.currentTimeMillis() - DW2c3GM8;
				averageConnectTime = (averageConnectTime * (averageSampleSize - 1) + LEEkDVXh) / averageSampleSize;
				if (geoNamesServerFailover != null && averageConnectTime > 5000
						&& !eOA3RSag.equals(geoNamesServerFailover)) {
					timeOfLastFailureMainServer = System.currentTimeMillis();
				}
				return EkPlPEM0;
			}
		} catch (IOException ShMzZYuN) {
			return tryFailoverServer(O7I78zV0, eOA3RSag, 0, ShMzZYuN);
		}
		IOException Kc0sY4QR = new IOException("status code " + KxsU1PmH + " for " + O7I78zV0);
		return tryFailoverServer(O7I78zV0, eOA3RSag, KxsU1PmH, Kc0sY4QR);
	}

}