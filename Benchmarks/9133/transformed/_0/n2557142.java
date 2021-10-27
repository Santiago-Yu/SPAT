class n2557142 {
	public void login(LoginData f1eWdnQ1) throws ConnectionEstablishException, AccessDeniedException {
		try {
			int W5PmZYH6;
			this.ftpClient.connect(f1eWdnQ1.getFtpServer());
			W5PmZYH6 = this.ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(W5PmZYH6)) {
				this.ftpClient.disconnect();
				throw (new ConnectionEstablishException("FTP server refused connection."));
			}
		} catch (IOException Nv2NRHW3) {
			if (this.ftpClient.isConnected()) {
				try {
					this.ftpClient.disconnect();
				} catch (IOException LLlYICN5) {
				}
			}
			Nv2NRHW3.printStackTrace();
			throw (new ConnectionEstablishException("Could not connect to server.", Nv2NRHW3));
		}
		try {
			if (!this.ftpClient.login(f1eWdnQ1.getFtpBenutzer(), f1eWdnQ1.getFtpPasswort())) {
				this.logout();
				throw (new AccessDeniedException("Could not login into server."));
			}
		} catch (IOException GupK8mHk) {
			GupK8mHk.printStackTrace();
			throw (new AccessDeniedException("Could not login into server.", GupK8mHk));
		}
	}

}