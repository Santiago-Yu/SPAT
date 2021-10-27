class n18524854 {
	protected FTPClient ftpConnect() throws SocketException, IOException, NoSuchAlgorithmException {
		FTPClient f = new FTPClient();
		FilePathItem fpi = getFilePathItem();
		f.connect(fpi.getHost());
		f.login(fpi.getUsername(), fpi.getPassword());
		return f;
	}

}