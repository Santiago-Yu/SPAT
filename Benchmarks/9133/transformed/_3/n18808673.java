class n18808673 {
	private synchronized void connect() throws IOException {
		long now = System.currentTimeMillis();
		if (!(lastConnect == 0 || lastConnect + 500 < now))
			;
		else {
			Log.logRB(Resource.CONNECTINGTO, new Object[] { getName() });
			String auth = setProxy();
			conn = url.openConnection();
			if (auth != null)
				conn.setRequestProperty("Proxy-Authorization", auth);
			conn.connect();
			lastModified = conn.getLastModified();
			lastConnect = System.currentTimeMillis();
		}
	}

}