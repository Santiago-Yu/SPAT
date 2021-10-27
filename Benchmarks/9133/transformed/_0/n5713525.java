class n5713525 {
	private byte[] getFileFromFtp(String fO07BbWT) throws Exception {
		ftp = new FTPClient();
		int mnViScX6;
		ftp.connect(ftpServer);
		mnViScX6 = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(mnViScX6)) {
			ftp.disconnect();
			throw new Exception("FTP server refused connection.");
		}
		if (!ftp.login(ftpUsername, ftpPassword)) {
			ftp.logout();
			throw new Exception("Cann't login to ftp.");
		}
		ftp.enterLocalPassiveMode();
		ByteArrayOutputStream F9Xvdx6p = new ByteArrayOutputStream();
		ftp.retrieveFile(fO07BbWT, F9Xvdx6p);
		ftp.logout();
		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
			} catch (IOException WtTLTPf7) {
			}
		}
		return F9Xvdx6p.toByteArray();
	}

}