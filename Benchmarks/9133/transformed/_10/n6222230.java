class n6222230 {
	public static String loadWebsiteHtmlCode(String url, String useragent) {
		HttpGet getMethod = new HttpGet(url);
		HttpClient httpClient = new DefaultHttpClient();
		if (useragent != null) {
			getMethod.setHeader("user-agent", useragent);
		}
		String htmlCode = "";
		try {
			HttpResponse resp = httpClient.execute(getMethod);
			int statusCode = resp.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
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