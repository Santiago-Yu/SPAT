class n10151252 {
	public static void upload(FTPDetails bTf6HyoB) {
		FTPClient AIGAU0ED = new FTPClient();
		try {
			String iOywYxvy = bTf6HyoB.getHost();
			logger.info("Connecting to ftp host: " + iOywYxvy);
			AIGAU0ED.connect(iOywYxvy);
			logger.info("Received reply from ftp :" + AIGAU0ED.getReplyString());
			AIGAU0ED.login(bTf6HyoB.getUserName(), bTf6HyoB.getPassword());
			AIGAU0ED.setFileType(FTP.BINARY_FILE_TYPE);
			AIGAU0ED.makeDirectory(bTf6HyoB.getRemoterDirectory());
			logger.info("Created directory :" + bTf6HyoB.getRemoterDirectory());
			AIGAU0ED.changeWorkingDirectory(bTf6HyoB.getRemoterDirectory());
			BufferedInputStream t9058ijL = new BufferedInputStream(
					new FileInputStream(new File(bTf6HyoB.getLocalFilePath())));
			OutputStream XCwk3Phx = AIGAU0ED.storeFileStream(bTf6HyoB.getRemoteFileName());
			IOUtils.copy(t9058ijL, XCwk3Phx);
			logger.info("Copied file : " + bTf6HyoB.getLocalFilePath() + " >>> " + iOywYxvy + ":/"
					+ bTf6HyoB.getRemoterDirectory() + "/" + bTf6HyoB.getRemoteFileName());
			t9058ijL.close();
			XCwk3Phx.close();
			AIGAU0ED.logout();
			AIGAU0ED.disconnect();
			logger.info("Logged out. ");
		} catch (Exception doW2iURA) {
			throw new RuntimeException(doW2iURA);
		}
	}

}