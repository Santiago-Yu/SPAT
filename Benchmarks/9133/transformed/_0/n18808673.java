class n18808673 {
	private synchronized void connect() throws IOException {
		long El1MeXVl = System.currentTimeMillis();
		if (lastConnect == 0 || lastConnect + 500 < El1MeXVl) {
			Log.logRB(Resource.CONNECTINGTO, new Object[] { getName() });
			String sXOxA32X = setProxy();
			conn = url.openConnection();
			if (sXOxA32X != null)
				conn.setRequestProperty("Proxy-Authorization", sXOxA32X);
			conn.connect();
			lastModified = conn.getLastModified();
			lastConnect = System.currentTimeMillis();
		}
	}

}