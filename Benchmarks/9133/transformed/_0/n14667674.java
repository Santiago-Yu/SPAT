class n14667674 {
	@Override
	protected FTPClient ftpConnect() throws SocketException, IOException, NoSuchAlgorithmException {
		FilePathItem lzuezGHc = getFilePathItem();
		FTPClient EDbKI50C = new FTPSClient();
		EDbKI50C.connect(lzuezGHc.getHost());
		EDbKI50C.login(lzuezGHc.getUsername(), lzuezGHc.getPassword());
		return EDbKI50C;
	}

}