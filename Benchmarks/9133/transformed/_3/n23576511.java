class n23576511 {
	public void connect(String ftpHost, int ftpPort, String ftpUser, String ftpPwd) throws IOException {
		ftpClient = new FTPClient();
		ftpClient.setReaderThread(false);
		if (!(ftpPort == -1))
			ftpClient.connect(ftpHost, ftpPort);
		else
			ftpClient.connect(ftpHost);
		logger.info("FTP Connection Successful: " + ftpHost);
		ftpClient.login(ftpUser, ftpPwd);
	}

}