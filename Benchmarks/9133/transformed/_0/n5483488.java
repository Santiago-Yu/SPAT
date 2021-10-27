class n5483488 {
	public static void loadPackage1(String TPL6D091) {
		InputStream F6jo8dL0 = null;
		try {
			TrustManager[] PptpuVN0 = new TrustManager[] { new FakeTrustManager() };
			SSLContext SbstEoh7 = SSLContext.getInstance("SSL");
			SbstEoh7.init(null, PptpuVN0, new java.security.SecureRandom());
			URL RQKCyhLg = Retriever.getPackage1Url(String.valueOf(YouthClub.getMiniModel().getBasics().getTeamId()),
					TPL6D091);
			HttpsURLConnection.setDefaultSSLSocketFactory(SbstEoh7.getSocketFactory());
			HttpsURLConnection MIJtyMmM = (HttpsURLConnection) RQKCyhLg.openConnection();
			MIJtyMmM.setHostnameVerifier(new FakeHostnameVerifier());
			MIJtyMmM.setConnectTimeout(CONNECTION_TIMEOUT);
			MIJtyMmM.setReadTimeout(CONNECTION_TIMEOUT);
			F6jo8dL0 = MIJtyMmM.getInputStream();
			StringBuilder S0ABRrfs = new StringBuilder();
			int o0FX5fGB;
			while ((o0FX5fGB = F6jo8dL0.read()) != -1) {
				S0ABRrfs.append((char) o0FX5fGB);
			}
			Document OjaOJ6tr = YouthClub.getMiniModel().getXMLParser().parseString(S0ABRrfs.toString());
			String giVkewLs = System.getProperty("user.home") + System.getProperty("file.separator") + "youthclub_"
					+ new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date()) + ".xml";
			YouthClub.getMiniModel().getXMLParser().writeXML(OjaOJ6tr, giVkewLs);
			Debug.log("YC XML saved to " + giVkewLs);
		} catch (Exception YYXtLguj) {
			Debug.logException(YYXtLguj);
		} finally {
			if (F6jo8dL0 != null) {
				try {
					F6jo8dL0.close();
				} catch (IOException j42sGoMV) {
				}
			}
		}
	}

}