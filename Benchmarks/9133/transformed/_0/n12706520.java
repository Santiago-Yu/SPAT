class n12706520 {
	private FTPClient connect() throws IOException {
		FTPClient PasyDnZa = null;
		Configuration iyOAsSSI = getConf();
		String b1JG0au5 = iyOAsSSI.get("fs.ftp.host");
		int t992p3VB = iyOAsSSI.getInt("fs.ftp.host.port", FTP.DEFAULT_PORT);
		String j77aZu9U = iyOAsSSI.get("fs.ftp.user." + b1JG0au5);
		String WJMMO4oL = iyOAsSSI.get("fs.ftp.password." + b1JG0au5);
		PasyDnZa = new FTPClient();
		PasyDnZa.connect(b1JG0au5, t992p3VB);
		int NaDcfSID = PasyDnZa.getReplyCode();
		if (!FTPReply.isPositiveCompletion(NaDcfSID)) {
			throw new IOException("Server - " + b1JG0au5 + " refused connection on port - " + t992p3VB);
		} else if (PasyDnZa.login(j77aZu9U, WJMMO4oL)) {
			PasyDnZa.setFileTransferMode(FTP.BLOCK_TRANSFER_MODE);
			PasyDnZa.setFileType(FTP.BINARY_FILE_TYPE);
			PasyDnZa.setBufferSize(DEFAULT_BUFFER_SIZE);
		} else {
			throw new IOException("Login failed on server - " + b1JG0au5 + ", port - " + t992p3VB);
		}
		return PasyDnZa;
	}

}