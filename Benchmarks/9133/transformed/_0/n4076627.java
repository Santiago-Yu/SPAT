class n4076627 {
	public void openFtpConnection(String MwDrkGeB) throws RQLException {
		try {
			ftpClient = new FTPClient();
			ftpClient.connect(server);
			ftpClient.login(user, password);
			ftpClient.changeWorkingDirectory(MwDrkGeB);
		} catch (IOException seDCkkPi) {
			throw new RQLException("FTP client could not be created. Please check attributes given in constructor.",
					seDCkkPi);
		}
	}

}