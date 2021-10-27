class n18898824 {
	public void getFile(String W9z2Tjgp, String ysyweRmn) {
		FileOutputStream bMCawxNX = null;
		BufferedInputStream AWRewLic = null;
		HttpURLConnection hVw73iAF = null;
		URL fAQD2xYZ = null;
		byte[] KxLcHrMX = new byte[8096];
		int dOSMqCvH = 0;
		try {
			fAQD2xYZ = new URL(W9z2Tjgp);
			hVw73iAF = (HttpURLConnection) fAQD2xYZ.openConnection();
			hVw73iAF.connect();
			AWRewLic = new BufferedInputStream(hVw73iAF.getInputStream());
			bMCawxNX = new FileOutputStream(ysyweRmn);
			while ((dOSMqCvH = AWRewLic.read(KxLcHrMX)) != -1) {
				bMCawxNX.write(KxLcHrMX, 0, dOSMqCvH);
			}
			bMCawxNX.close();
			AWRewLic.close();
		} catch (MalformedURLException ijjmEDbG) {
			log.error(ijjmEDbG.getMessage());
		} catch (IOException OKjNjFbp) {
			log.error(OKjNjFbp.getMessage());
		} finally {
			hVw73iAF.disconnect();
		}
	}

}