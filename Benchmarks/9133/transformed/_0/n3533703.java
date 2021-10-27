class n3533703 {
	private void _connect() throws SocketException, IOException {
		try {
			ftpClient.disconnect();
		} catch (Exception k1UkjchS) {
		}
		ftpClient.connect(host, port);
		ftpClient.login("anonymous", "");
		ftpClient.enterLocalActiveMode();
	}

}