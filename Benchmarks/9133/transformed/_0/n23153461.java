class n23153461 {
	private FTPClient getClient() throws SocketException, IOException {
		FTPClient SYM2s0Hn = new FTPClient();
		SYM2s0Hn.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		SYM2s0Hn.setDefaultPort(getPort());
		SYM2s0Hn.connect(getIp());
		int c8sTczW2 = SYM2s0Hn.getReplyCode();
		if (!FTPReply.isPositiveCompletion(c8sTczW2)) {
			log.warn("FTP server refused connection: {}", getIp());
			SYM2s0Hn.disconnect();
			return null;
		}
		if (!SYM2s0Hn.login(getUsername(), getPassword())) {
			log.warn("FTP server refused login: {}, user: {}", getIp(), getUsername());
			SYM2s0Hn.logout();
			SYM2s0Hn.disconnect();
			return null;
		}
		SYM2s0Hn.setControlEncoding(getEncoding());
		SYM2s0Hn.setFileType(FTP.BINARY_FILE_TYPE);
		SYM2s0Hn.enterLocalPassiveMode();
		return SYM2s0Hn;
	}

}