class n19936443 {
	public boolean connect() {
		try {
			int wwVXSczp;
			ftp.connect(server, port);
			wwVXSczp = ftp.getReplyCode();
			if (FTPReply.isPositiveCompletion(wwVXSczp)) {
				if (ftp.login(username, password)) {
					ftp.enterLocalPassiveMode();
					return true;
				}
			} else {
				ftp.disconnect();
				System.out.println("FTP server refused connection.");
			}
		} catch (IOException ihH4eAbe) {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException FyXHU5sL) {
				}
			}
			System.out.println("Could not connect to server.");
		}
		return false;
	}

}