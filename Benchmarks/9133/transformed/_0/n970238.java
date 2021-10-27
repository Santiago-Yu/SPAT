class n970238 {
	public static FTPClient getFtpClient(TopAnalysisConfig Bezjkxb0) throws SocketException, IOException {
		FTPClient lTR1Cmfh = new FTPClient();
		lTR1Cmfh.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		lTR1Cmfh.connect(Bezjkxb0.getFtpServer());
		int PMbC9Zmp = lTR1Cmfh.getReplyCode();
		if (!FTPReply.isPositiveCompletion(PMbC9Zmp)) {
			lTR1Cmfh.disconnect();
			throw new java.lang.RuntimeException("PullFileJobWorker connect ftp error!");
		}
		if (!lTR1Cmfh.login(Bezjkxb0.getFtpUserName(), Bezjkxb0.getFtpPassWord())) {
			lTR1Cmfh.logout();
			throw new java.lang.RuntimeException("PullFileJobWorker login ftp error!");
		}
		logger.info("Remote system is " + lTR1Cmfh.getSystemName());
		lTR1Cmfh.setFileType(FTP.BINARY_FILE_TYPE);
		if (Bezjkxb0.isLocalPassiveMode())
			lTR1Cmfh.enterLocalPassiveMode();
		return lTR1Cmfh;
	}

}