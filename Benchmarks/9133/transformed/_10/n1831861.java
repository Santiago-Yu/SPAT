class n1831861 {
	private Document getXML(String artist) throws Exception {
		URL url = new URL("http://" + disgogsUrl + "/artist/" + formatQuery(artist) + "?f=xml&api_key=" + apiKey[0]);
		Document doc = null;
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.addRequestProperty("Accept-Encoding", "gzip");
		BufferedReader ir = null;
		if (StaticObj.PROXY_ENABLED) {
			Properties systemSettings = System.getProperties();
			systemSettings.put("http.proxyHost", StaticObj.PROXY_URL);
			systemSettings.put("http.proxyPort", StaticObj.PROXY_PORT);
			System.setProperties(systemSettings);
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			String encoded = new String(
					encoder.encode(new String(StaticObj.PROXY_USERNAME + ":" + StaticObj.PROXY_PASSWORD).getBytes()));
			uc.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
		}
		try {
			if (uc.getInputStream() != null) {
				InputStream _is = uc.getInputStream();
				GZIPInputStream _gzipIs = new GZIPInputStream(_is);
				InputStreamReader _isReader = new InputStreamReader(_gzipIs);
				SAXBuilder builder = new SAXBuilder();
				ir = new BufferedReader(_isReader);
				doc = builder.build(ir);
			}
		} catch (Exception e) {
			if (StaticObj.DEBUG) {
				LogManager.getInstance().getLogger().error(e);
				e.printStackTrace();
				System.out.println("No Data found!");
			}
		}
		return doc;
	}

}