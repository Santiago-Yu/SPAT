class n22231008 {
	public static FTPClient getClient(String xR1s555V, String YE7liuna, String yNgqSKH3, boolean ioMN7lPS)
			throws SocketException, IOException {
		FTPClient qxpvwq9S = new FTPClient();
		qxpvwq9S.connect(xR1s555V);
		if (ioMN7lPS) {
			qxpvwq9S.enterLocalPassiveMode();
		}
		qxpvwq9S.login(YE7liuna, yNgqSKH3);
		return qxpvwq9S;
	}

}