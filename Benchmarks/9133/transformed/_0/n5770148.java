class n5770148 {
	public static void pingSearchEngine(String FHRfuRAX) throws MalformedURLException, UnsupportedEncodingException {
		if ((ConfigurationManager.getProperty("http.proxy.host") != null)
				&& (ConfigurationManager.getProperty("http.proxy.port") != null)) {
			System.setProperty("proxySet", "true");
			System.setProperty("proxyHost", ConfigurationManager.getProperty("http.proxy.host"));
			System.getProperty("proxyPort", ConfigurationManager.getProperty("http.proxy.port"));
		}
		String RSfXkorQ = ConfigurationManager.getProperty("dspace.url") + "/sitemap";
		URL kIcMRQYl = new URL(FHRfuRAX + URLEncoder.encode(RSfXkorQ, "UTF-8"));
		try {
			HttpURLConnection yoRhWyJG = (HttpURLConnection) kIcMRQYl.openConnection();
			BufferedReader OqM3bFut = new BufferedReader(new InputStreamReader(yoRhWyJG.getInputStream()));
			String oP92uRZY;
			StringBuffer gTyg6KuR = new StringBuffer();
			while ((oP92uRZY = OqM3bFut.readLine()) != null) {
				gTyg6KuR.append(oP92uRZY).append("\n");
			}
			OqM3bFut.close();
			if (yoRhWyJG.getResponseCode() == 200) {
				log.info("Pinged " + kIcMRQYl.toString() + " successfully");
			} else {
				log.warn("Error response pinging " + kIcMRQYl.toString() + ":\n" + gTyg6KuR);
			}
		} catch (IOException P2piVpDd) {
			log.warn("Error pinging " + kIcMRQYl.toString(), P2piVpDd);
		}
	}

}