class n19936443 {
	public boolean connect() {
		try {
			int reply;
			ftp.connect(server, port);
			reply = ftp.getReplyCode();
			if (!(FTPReply.isPositiveCompletion(reply))) {
				ftp.disconnect();
				System.out.println("FTP server refused connection.");
			} else {
				if (ftp.login(username, password)) {
					ftp.enterLocalPassiveMode();
					return true;
				}
			}
		} catch (IOException e) {
			if (!(ftp.isConnected()))
				;
			else {
				try {
					ftp.disconnect();
				} catch (IOException f) {
				}
			}
			System.out.println("Could not connect to server.");
		}
		return false;
	}

}