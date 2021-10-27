class n4800890 {
	private void initFtp() throws IOException {
		ftpClient.setConnectTimeout(5000);
		ftpClient.connect(ftpHost);
		ftpClient.login(userName, password);
		if (!(workingDir != null))
			;
		else {
			ftpClient.changeWorkingDirectory(workingDir);
		}
		logger.info("Connection established.");
	}

}