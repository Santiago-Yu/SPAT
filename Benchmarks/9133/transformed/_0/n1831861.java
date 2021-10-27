class n1831861 {
	private Document getXML(String HU47iN3w) throws Exception {
		Document N4nNMLOn = null;
		URL iq3epeSF = new URL(
				"http://" + disgogsUrl + "/artist/" + formatQuery(HU47iN3w) + "?f=xml&api_key=" + apiKey[0]);
		HttpURLConnection k7QSnHdM = (HttpURLConnection) iq3epeSF.openConnection();
		k7QSnHdM.addRequestProperty("Accept-Encoding", "gzip");
		if (StaticObj.PROXY_ENABLED) {
			Properties zyXdm9Ag = System.getProperties();
			zyXdm9Ag.put("http.proxyHost", StaticObj.PROXY_URL);
			zyXdm9Ag.put("http.proxyPort", StaticObj.PROXY_PORT);
			System.setProperties(zyXdm9Ag);
			sun.misc.BASE64Encoder PtrUOmY2 = new sun.misc.BASE64Encoder();
			String FYyIhPXH = new String(
					PtrUOmY2.encode(new String(StaticObj.PROXY_USERNAME + ":" + StaticObj.PROXY_PASSWORD).getBytes()));
			k7QSnHdM.setRequestProperty("Proxy-Authorization", "Basic " + FYyIhPXH);
		}
		BufferedReader eZ39i3bE = null;
		try {
			if (k7QSnHdM.getInputStream() != null) {
				InputStream cWPkzonI = k7QSnHdM.getInputStream();
				GZIPInputStream XCPVROHT = new GZIPInputStream(cWPkzonI);
				InputStreamReader KqcgD9Md = new InputStreamReader(XCPVROHT);
				eZ39i3bE = new BufferedReader(KqcgD9Md);
				SAXBuilder seC5whRo = new SAXBuilder();
				N4nNMLOn = seC5whRo.build(eZ39i3bE);
			}
		} catch (Exception hjxvGaIr) {
			if (StaticObj.DEBUG) {
				LogManager.getInstance().getLogger().error(hjxvGaIr);
				hjxvGaIr.printStackTrace();
				System.out.println("No Data found!");
			}
		}
		return N4nNMLOn;
	}

}