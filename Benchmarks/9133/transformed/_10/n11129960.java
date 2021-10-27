class n11129960 {
	public static String getGoGl(final String urlPath, String key) {
		log.debug("getGoGl url " + urlPath);
		log.debug("getGoGl key " + key);
		URL simpleURL = null;
		String shortUrl = null;
		BufferedInputStream bStream = null;
		HttpsURLConnection url = null;
		String inputString = "{\"longUrl\":\"" + urlPath + "\"}";
		StringBuffer resultString = new StringBuffer("");
		log.debug("getGoGl inputString " + inputString);
		try {
			simpleURL = new URL("https://www.googleapis.com/urlshortener/v1/url?key=" + key);
			url = (HttpsURLConnection) simpleURL.openConnection();
			url.setDoOutput(true);
			url.setRequestProperty("content-type", "application/json");
			PrintWriter pw = new PrintWriter(url.getOutputStream());
			pw.print(inputString);
			pw.close();
		} catch (Exception ex) {
			log.error(ex);
			shortUrl = urlPath;
		}
		try {
			int i;
			bStream = new BufferedInputStream(url.getInputStream());
			while ((i = bStream.read()) >= 0) {
				resultString.append((char) i);
			}
		} catch (Exception ex) {
			SocialUtils.log.error(ex);
			shortUrl = urlPath;
		}
		return shortUrl;
	}

}