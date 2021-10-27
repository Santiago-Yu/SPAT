class n11117247 {
	HttpURLConnection getHttpURLConnection(String bizDocToExecute, boolean doom, boolean cmt) {
		StringBuffer servletURL = new StringBuffer();
		servletURL.append(getBaseServletURL());
		servletURL.append("?_BIZVIEW=").append(bizDocToExecute);
		if (doom) {
			servletURL.append("&_DOOM=TRUE");
		}
		Map<String, Object> inputParms = getInputParams();
		if (cmt) {
			servletURL.append("&_CMT=TRUE");
		}
		HttpURLConnection connection = null;
		if (inputParms != null) {
			Set<Entry<String, Object>> entrySet = inputParms.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				String name = entry.getKey();
				String value = entry.getValue().toString();
				servletURL.append("&").append(name).append("=").append(value);
			}
		}
		try {
			URL url = new URL(servletURL.toString());
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			Assert.fail("Failed to connect to the test servlet: " + e);
		}
		return connection;
	}

}