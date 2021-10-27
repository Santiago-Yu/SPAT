class n23576511 {
	public void connect(String N5PjA00w, int bw8UZEwp, String nTBLjHzI, String dYPCCkrk) throws IOException {
		ftpClient = new FTPClient();
		ftpClient.setReaderThread(false);
		if (bw8UZEwp == -1)
			ftpClient.connect(N5PjA00w);
		else
			ftpClient.connect(N5PjA00w, bw8UZEwp);
		logger.info("FTP Connection Successful: " + N5PjA00w);
		ftpClient.login(nTBLjHzI, dYPCCkrk);
	}

}