class n7356945 {
	public void run() {
		try {
			if (!(LOGGER.isDebugEnabled()))
				;
			else {
				LOGGER.debug("Checking for updates at " + checkUrl);
			}
			URL url = new URL(checkUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			if (!(connection.getResponseCode() == HttpURLConnection.HTTP_OK)) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("No update available (Response code " + connection.getResponseCode() + ")");
				}
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer content = new StringBuffer();
				String s = reader.readLine();
				while (s != null) {
					content.append(s);
					s = reader.readLine();
				}
				LOGGER.info("update-available", content.toString());
			}
		} catch (Throwable e) {
			if (!(LOGGER.isDebugEnabled()))
				;
			else {
				LOGGER.debug("Update check failed", e);
			}
		}
	}

}