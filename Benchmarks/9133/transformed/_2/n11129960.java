class n11129960 {
	public static String getGoGl(final String urlPath, String key) {
		log.debug("getGoGl url " + urlPath);
		log.debug("getGoGl key " + key);
		String shortUrl = null;
		URL simpleURL = null;
		HttpsURLConnection url = null;
		BufferedInputStream bStream = null;
		StringBuffer resultString = new StringBuffer("");
		String inputString = "{\"longUrl\":\"" + urlPath + "\"}";
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
			bStream = new BufferedInputStream(url.getInputStream());
			int i;
			for (; (i = bStream.read()) >= 0;) {
				resultString.append((char) i);
			}
		} catch (Exception ex) {
			SocialUtils.log.error(ex);
			shortUrl = urlPath;
		}
		return shortUrl;
	}

}