class n2736180 {
	public static byte[] getURLContent(String RdN5u90W) {
		HttpURLConnection UJtdcxuD = null;
		InputStream paLnMIAd = null;
		byte[] sn00jGG0 = null;
		try {
			URL bztc4nmY = new URL(RdN5u90W);
			HttpURLConnection.setFollowRedirects(false);
			UJtdcxuD = (HttpURLConnection) bztc4nmY.openConnection();
			UJtdcxuD.setRequestMethod("GET");
			UJtdcxuD.setDoOutput(true);
			UJtdcxuD.setUseCaches(false);
			UJtdcxuD.setDefaultUseCaches(false);
			UJtdcxuD.setConnectTimeout(10000);
			UJtdcxuD.setReadTimeout(60000);
			UJtdcxuD.connect();
			int cWh05Mgy = UJtdcxuD.getResponseCode();
			if (cWh05Mgy == 200) {
				paLnMIAd = UJtdcxuD.getInputStream();
				int QX2xJgzj = UJtdcxuD.getContentLength();
				sn00jGG0 = getResponseBody(paLnMIAd, QX2xJgzj);
			}
		} catch (Exception G33wMzPi) {
			logger.error("", G33wMzPi);
		} finally {
			try {
				if (paLnMIAd != null) {
					paLnMIAd.close();
				}
				if (UJtdcxuD != null) {
					UJtdcxuD.disconnect();
				}
			} catch (Exception H87YVqQ4) {
			}
		}
		return sn00jGG0;
	}

}