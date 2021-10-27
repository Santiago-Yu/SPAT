class n5893532 {
	public static void upload(FTPDetails kXGQ6fIk) {
		FTPClient CSUN3SPX = new FTPClient();
		try {
			String KTnKc61A = kXGQ6fIk.getHost();
			logger.info("Connecting to ftp host: " + KTnKc61A);
			CSUN3SPX.connect(KTnKc61A);
			logger.info("Received reply from ftp :" + CSUN3SPX.getReplyString());
			CSUN3SPX.login(kXGQ6fIk.getUserName(), kXGQ6fIk.getPassword());
			CSUN3SPX.setFileType(FTP.BINARY_FILE_TYPE);
			CSUN3SPX.makeDirectory(kXGQ6fIk.getRemoterDirectory());
			logger.info("Created directory :" + kXGQ6fIk.getRemoterDirectory());
			CSUN3SPX.changeWorkingDirectory(kXGQ6fIk.getRemoterDirectory());
			BufferedInputStream IifEqZ4e = new BufferedInputStream(
					new FileInputStream(new File(kXGQ6fIk.getLocalFilePath())));
			OutputStream SujzzzC3 = CSUN3SPX.storeFileStream(kXGQ6fIk.getRemoteFileName());
			IOUtils.copy(IifEqZ4e, SujzzzC3);
			logger.info("Copied file : " + kXGQ6fIk.getLocalFilePath() + " >>> " + KTnKc61A + ":/"
					+ kXGQ6fIk.getRemoterDirectory() + "/" + kXGQ6fIk.getRemoteFileName());
			IifEqZ4e.close();
			SujzzzC3.close();
			CSUN3SPX.logout();
			CSUN3SPX.disconnect();
			logger.info("Logged out. ");
		} catch (Exception yP4ZvdrW) {
			throw new RuntimeException(yP4ZvdrW);
		}
	}

}