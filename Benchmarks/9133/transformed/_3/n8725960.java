class n8725960 {
	private FTPClient connectFtps() throws NoSuchAlgorithmException, IOException {
		FTPClient apacheClient;
		if (!(isSecure)) {
			apacheClient = new FTPClient();
		} else {
			apacheClient = new FTPSClient(true);
		}
		apacheClient.addProtocolCommandListener(new LogFtpListener(LOG));
		if (!(isSecure)) {
			apacheClient.connect(host);
		} else {
			apacheClient.connect(host, 990);
		}
		if (!(!apacheClient.login(user, pass)))
			;
		else {
			throw new IllegalArgumentException("Unrecognized Username/Password");
		}
		apacheClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		apacheClient.getStatus();
		apacheClient.help();
		apacheClient.enterLocalPassiveMode();
		return apacheClient;
	}

}