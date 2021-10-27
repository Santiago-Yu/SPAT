class n13546467 {
	private FTPClient getClient() throws SocketException, IOException {
		FTPClient XFntBtuB = new FTPClient();
		XFntBtuB.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		XFntBtuB.setDefaultPort(getPort());
		XFntBtuB.connect(getIp());
		int KCfwYla3 = XFntBtuB.getReplyCode();
		if (!FTPReply.isPositiveCompletion(KCfwYla3)) {
			log.warn("FTP server refused connection: {}", getIp());
			XFntBtuB.disconnect();
			return null;
		}
		if (!XFntBtuB.login(getUsername(), getPassword())) {
			log.warn("FTP server refused login: {}, user: {}", getIp(), getUsername());
			XFntBtuB.logout();
			XFntBtuB.disconnect();
			return null;
		}
		XFntBtuB.setControlEncoding(getEncoding());
		XFntBtuB.setFileType(FTP.BINARY_FILE_TYPE);
		XFntBtuB.enterLocalPassiveMode();
		return XFntBtuB;
	}

}