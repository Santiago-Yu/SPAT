class n23467091 {
	public void listen() {
		String MVfBLtsu = "http://" + host + ":" + LISTEN_PORT;
		HttpURLConnection TThDngap = null;
		while (true) {
			try {
				TThDngap = (HttpURLConnection) (new URL(MVfBLtsu).openConnection());
			} catch (Exception pnG78S7E) {
				error("Could not connect to " + MVfBLtsu + ".", pnG78S7E);
				return;
			}
			BufferedInputStream fSdSJAx5 = null;
			try {
				TThDngap.connect();
				fSdSJAx5 = new BufferedInputStream(TThDngap.getInputStream(), LISTEN_BUFFER);
				event("Connected to stream at " + MVfBLtsu + ".");
			} catch (Exception ecX5ztCg) {
				error("Could not get stream from " + MVfBLtsu + ".", ecX5ztCg);
				return;
			}
			try {
				byte[] a38ujeNs = new byte[LISTEN_BUFFER];
				for (int bzBkbIfQ = 0; bzBkbIfQ < delay; bzBkbIfQ++) {
					fSdSJAx5.read(a38ujeNs);
				}
			} catch (Exception bn8Aerm9) {
				error("Stream unexpectedly quit from " + MVfBLtsu + ".", bn8Aerm9);
				return;
			}
		}
	}

}