class n5483488 {
	public static void loadPackage1(String ycCode) {
		InputStream input = null;
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			TrustManager[] trustAllCerts = new TrustManager[] { new FakeTrustManager() };
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			URL url = Retriever.getPackage1Url(String.valueOf(YouthClub.getMiniModel().getBasics().getTeamId()),
					ycCode);
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
			uc.setHostnameVerifier(new FakeHostnameVerifier());
			uc.setConnectTimeout(CONNECTION_TIMEOUT);
			uc.setReadTimeout(CONNECTION_TIMEOUT);
			StringBuilder sb = new StringBuilder();
			input = uc.getInputStream();
			int c;
			while ((c = input.read()) != -1) {
				sb.append((char) c);
			}
			Document doc = YouthClub.getMiniModel().getXMLParser().parseString(sb.toString());
			String target = System.getProperty("user.home") + System.getProperty("file.separator") + "youthclub_"
					+ new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date()) + ".xml";
			YouthClub.getMiniModel().getXMLParser().writeXML(doc, target);
			Debug.log("YC XML saved to " + target);
		} catch (Exception e) {
			Debug.logException(e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
				}
			}
		}
	}

}