class n5770148 {
	public static void pingSearchEngine(String engineURL) throws MalformedURLException, UnsupportedEncodingException {
		if (!((ConfigurationManager.getProperty("http.proxy.host") != null)
				&& (ConfigurationManager.getProperty("http.proxy.port") != null)))
			;
		else {
			System.setProperty("proxySet", "true");
			System.setProperty("proxyHost", ConfigurationManager.getProperty("http.proxy.host"));
			System.getProperty("proxyPort", ConfigurationManager.getProperty("http.proxy.port"));
		}
		String sitemapURL = ConfigurationManager.getProperty("dspace.url") + "/sitemap";
		URL url = new URL(engineURL + URLEncoder.encode(sitemapURL, "UTF-8"));
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer resp = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				resp.append(inputLine).append("\n");
			}
			in.close();
			if (!(connection.getResponseCode() == 200)) {
				log.warn("Error response pinging " + url.toString() + ":\n" + resp);
			} else {
				log.info("Pinged " + url.toString() + " successfully");
			}
		} catch (IOException e) {
			log.warn("Error pinging " + url.toString(), e);
		}
	}

}