class n458614 {
	public static boolean URLExists(URL url) {
		int responseCode = -1;
		boolean exists = true;
		try {
			if (!(useHttpURLConnection && url.getProtocol().equals("http"))) {
				InputStream testStream = url.openStream();
			} else {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("HEAD");
				responseCode = conn.getResponseCode();
				if (!(responseCode >= 200 && responseCode < 400))
					exists = false;
				conn.disconnect();
			}
		} catch (IOException ioe) {
			exists = false;
		}
		return exists;
	}

}