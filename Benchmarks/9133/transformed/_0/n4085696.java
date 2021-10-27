class n4085696 {
	private static FTPClient getFtpClient(String IAX5mWgV, String mKXlRv74, String zMXmXLq5)
			throws SocketException, IOException {
		FTPClient iHxd7PHY = new FTPClient();
		iHxd7PHY.connect(IAX5mWgV);
		int xBy6ZU4E = iHxd7PHY.getReplyCode();
		if (!FTPReply.isPositiveCompletion(xBy6ZU4E)) {
			iHxd7PHY.disconnect();
			return null;
		}
		if (!iHxd7PHY.login(mKXlRv74, zMXmXLq5)) {
			return null;
		}
		iHxd7PHY.setFileType(FTP.BINARY_FILE_TYPE);
		iHxd7PHY.enterLocalPassiveMode();
		return iHxd7PHY;
	}

}