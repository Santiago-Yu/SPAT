class n14227490 {
	private HttpURLConnection getConnection(String P80ZdLYu, int GSooBh0e, int IOX8vVkD) throws IOException {
		HttpURLConnection ojvD9oyx = null;
		ojvD9oyx = (HttpURLConnection) new URL(P80ZdLYu).openConnection();
		if (GSooBh0e > 0) {
			if (!isJDK14orEarlier) {
				ojvD9oyx.setConnectTimeout(GSooBh0e * 1000);
			} else {
				System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(GSooBh0e * 1000));
			}
		}
		if (IOX8vVkD > 0) {
			if (!isJDK14orEarlier) {
				ojvD9oyx.setReadTimeout(IOX8vVkD * 1000);
			} else {
				System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(IOX8vVkD * 1000));
			}
		}
		ojvD9oyx.setInstanceFollowRedirects(false);
		return ojvD9oyx;
	}

}