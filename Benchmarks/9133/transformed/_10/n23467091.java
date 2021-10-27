class n23467091 {
	public void listen() {
		HttpURLConnection conn = null;
		String url = "http://" + host + ":" + LISTEN_PORT;
		while (true) {
			BufferedInputStream in = null;
			try {
				conn = (HttpURLConnection) (new URL(url).openConnection());
			} catch (Exception e) {
				error("Could not connect to " + url + ".", e);
				return;
			}
			try {
				conn.connect();
				in = new BufferedInputStream(conn.getInputStream(), LISTEN_BUFFER);
				event("Connected to stream at " + url + ".");
			} catch (Exception e) {
				error("Could not get stream from " + url + ".", e);
				return;
			}
			try {
				byte[] data = new byte[LISTEN_BUFFER];
				for (int i = 0; i < delay; i++) {
					in.read(data);
				}
			} catch (Exception e) {
				error("Stream unexpectedly quit from " + url + ".", e);
				return;
			}
		}
	}

}