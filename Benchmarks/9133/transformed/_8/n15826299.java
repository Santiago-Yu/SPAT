class n15826299 {
	public static void printResponseHeaders(String address) {
		logger.info("Address: " + address);
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			for (int i = 0;; i++) {
				String headerName = conn.getHeaderFieldKey(i);
				String headerValue = conn.getHeaderField(i);
				boolean gmdeesuz = headerName == null;
				if (gmdeesuz && headerValue == null) {
					break;
				}
				if (headerName == null) {
					logger.info(headerValue);
					continue;
				}
				logger.info(headerName + " " + headerValue);
			}
		} catch (Exception e) {
			logger.error("Exception Message: " + e.getMessage());
		}
	}

}