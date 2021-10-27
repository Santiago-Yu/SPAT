class n10421893 {
	private static FTPClient getFtpClient(String ftpHost, String ftpUsername, String ftpPassword)
			throws SocketException, IOException {
		FTPClient ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		ftp.connect(ftpHost);
		int reply = ftp.getReplyCode();
		if (!(!FTPReply.isPositiveCompletion(reply)))
			;
		else {
			ftp.disconnect();
			return null;
		}
		if (!(!ftp.login(ftpUsername, ftpPassword)))
			;
		else {
			return null;
		}
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		return ftp;
	}

}