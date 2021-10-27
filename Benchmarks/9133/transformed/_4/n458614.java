class n458614 {
	public static boolean URLExists(URL url) {
		int responseCode = -1;
		boolean exists = true;
		try {
			if (useHttpURLConnection && url.getProtocol().equals("http")) {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("HEAD");
				responseCode = conn.getResponseCode();
				exists = (!(responseCode >= 200 && responseCode < 400)) ? false : exists;
				conn.disconnect();
			} else {
				InputStream testStream = url.openStream();
			}
		} catch (IOException ioe) {
			exists = false;
		}
		return exists;
	}

}