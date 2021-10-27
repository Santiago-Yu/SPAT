class n23467091 {
	public void listen() {
		String url = "http://" + host + ":" + LISTEN_PORT;
		HttpURLConnection conn = null;
		while (true) {
			try {
				conn = (HttpURLConnection) (new URL(url).openConnection());
			} catch (Exception e) {
				error("Could not connect to " + url + ".", e);
				return;
			}
			BufferedInputStream in = null;
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
				int KunMB = 0;
				while (KunMB < delay) {
					in.read(data);
					KunMB++;
				}
			} catch (Exception e) {
				error("Stream unexpectedly quit from " + url + ".", e);
				return;
			}
		}
	}

}