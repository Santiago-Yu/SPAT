class n14667674 {
	@Override
	protected FTPClient ftpConnect() throws SocketException, IOException, NoSuchAlgorithmException {
		FTPClient f = new FTPSClient();
		FilePathItem fpi = getFilePathItem();
		f.connect(fpi.getHost());
		f.login(fpi.getUsername(), fpi.getPassword());
		return f;
	}

}