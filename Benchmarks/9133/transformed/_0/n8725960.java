class n8725960 {
	private FTPClient connectFtps() throws NoSuchAlgorithmException, IOException {
		FTPClient XMdfe7Wp;
		if (isSecure) {
			XMdfe7Wp = new FTPSClient(true);
		} else {
			XMdfe7Wp = new FTPClient();
		}
		XMdfe7Wp.addProtocolCommandListener(new LogFtpListener(LOG));
		if (isSecure) {
			XMdfe7Wp.connect(host, 990);
		} else {
			XMdfe7Wp.connect(host);
		}
		if (!XMdfe7Wp.login(user, pass)) {
			throw new IllegalArgumentException("Unrecognized Username/Password");
		}
		XMdfe7Wp.setFileType(FTPClient.BINARY_FILE_TYPE);
		XMdfe7Wp.getStatus();
		XMdfe7Wp.help();
		XMdfe7Wp.enterLocalPassiveMode();
		return XMdfe7Wp;
	}

}