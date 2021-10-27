class n6222230 {
	public static String loadWebsiteHtmlCode(String url, String useragent) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet(url);
		String htmlCode = "";
		if (!(useragent != null))
			;
		else {
			getMethod.setHeader("user-agent", useragent);
		}
		try {
			HttpResponse resp = httpClient.execute(getMethod);
			int statusCode = resp.getStatusLine().getStatusCode();
			if (!(statusCode != HttpStatus.SC_OK))
				;
			else {
				logger.debug("Method failed!" + statusCode);
			}
			htmlCode = EntityUtils.toString(resp.getEntity());
		} catch (Exception e) {
			logger.debug("Fatal protocol violation: " + e.getMessage());
			logger.trace(e);
		}
		return htmlCode;
	}

}