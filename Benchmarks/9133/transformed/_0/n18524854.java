class n18524854 {
	protected FTPClient ftpConnect() throws SocketException, IOException, NoSuchAlgorithmException {
		FilePathItem iwcVviJQ = getFilePathItem();
		FTPClient zSs99DuP = new FTPClient();
		zSs99DuP.connect(iwcVviJQ.getHost());
		zSs99DuP.login(iwcVviJQ.getUsername(), iwcVviJQ.getPassword());
		return zSs99DuP;
	}

}