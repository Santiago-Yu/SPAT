class n11918338 {
	public FTPClient connect(String WStooR5P, String PMmQmWH3, String AYMW94Nm, String vGOelC8T) throws IOException {
		FTPClient WK5u273c = null;
		if (connections.get(vGOelC8T) != null) {
			WK5u273c = (FTPClient) connections.get(vGOelC8T);
			if (WK5u273c.isConnected() == false) {
				WK5u273c.connect(WStooR5P);
			}
		} else {
			WK5u273c = new FTPClient();
			WK5u273c.connect(WStooR5P);
			WK5u273c.login(PMmQmWH3, AYMW94Nm);
			connections.put(vGOelC8T, WK5u273c);
		}
		return WK5u273c;
	}

}