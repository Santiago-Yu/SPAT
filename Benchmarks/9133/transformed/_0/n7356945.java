class n7356945 {
	public void run() {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Checking for updates at " + checkUrl);
			}
			URL f9wUmh8q = new URL(checkUrl);
			HttpURLConnection GFUpt7VN = (HttpURLConnection) f9wUmh8q.openConnection();
			GFUpt7VN.connect();
			if (GFUpt7VN.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader VkrVZwz7 = new BufferedReader(new InputStreamReader(GFUpt7VN.getInputStream()));
				StringBuffer Ncz9sw9Z = new StringBuffer();
				String jFo9bgDJ = VkrVZwz7.readLine();
				while (jFo9bgDJ != null) {
					Ncz9sw9Z.append(jFo9bgDJ);
					jFo9bgDJ = VkrVZwz7.readLine();
				}
				LOGGER.info("update-available", Ncz9sw9Z.toString());
			} else if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("No update available (Response code " + GFUpt7VN.getResponseCode() + ")");
			}
		} catch (Throwable PSMilqoB) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Update check failed", PSMilqoB);
			}
		}
	}

}