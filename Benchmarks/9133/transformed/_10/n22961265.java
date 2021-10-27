class n22961265 {
	public static String readFromURL(String sURL) {
		logger.info("com.rooster.utils.URLReader.readFromURL - Entry");
		String sWebPage = "";
		try {
			URL url = new URL(sURL);
			String inputLine = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null) {
				sWebPage += inputLine;
			}
			in.close();
		} catch (Exception e) {
			logger.debug("com.rooster.utils.URLReader.readFromURL - Error" + e);
		}
		logger.info("com.rooster.utils.URLReader.readFromURL - Exit");
		return sWebPage;
	}

}