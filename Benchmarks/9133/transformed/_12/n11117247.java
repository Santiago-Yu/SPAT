class n11117247 {
	HttpURLConnection getHttpURLConnection(String bizDocToExecute, boolean doom, boolean cmt) {
		StringBuffer servletURL = new StringBuffer();
		servletURL.append(getBaseServletURL());
		servletURL.append("?_BIZVIEW=").append(bizDocToExecute);
		if (doom) {
			servletURL.append("&_DOOM=TRUE");
		}
		if (cmt) {
			servletURL.append("&_CMT=TRUE");
		}
		Map<String, Object> inputParms = getInputParams();
		if (inputParms != null) {
			Set<Entry<String, Object>> entrySet = inputParms.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				String name = entry.getKey(), value = entry.getValue().toString();
				servletURL.append("&").append(name).append("=").append(value);
			}
		}
		HttpURLConnection connection = null;
		try {
			URL url = new URL(servletURL.toString());
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			Assert.fail("Failed to connect to the test servlet: " + e);
		}
		return connection;
	}

}