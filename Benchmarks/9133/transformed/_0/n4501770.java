class n4501770 {
	protected final void connectFtp() throws IOException {
		try {
			if (!this.ftpClient.isConnected()) {
				this.ftpClient.connect(getHost(), getPort());
				getLog().write(Level.INFO,
						String.format(getMessages().getString("FtpSuccessfullyConnected"), getHost()));
				int DjlIEILh = this.ftpClient.getReplyCode();
				if (!FTPReply.isPositiveCompletion(DjlIEILh)) {
					this.ftpClient.disconnect();
					throw new IOException(
							String.format(getMessages().getString("FtpErrorConnectingRefused"), getHost()));
				}
				if (getUsername() != null) {
					if (!this.ftpClient.login(getUsername(), getPassword())) {
						this.ftpClient.logout();
						disconnectFtp();
						throw new IOException(String.format(getMessages().getString("FtpErrorAuthorizing"), getHost()));
					}
				}
				this.ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				this.ftpClient.enterLocalPassiveMode();
				getLog().write(Level.INFO,
						String.format(getMessages().getString("FtpSuccessfullyAuthorized"), getHost()));
			}
		} catch (IOException nAiseJC1) {
			disconnectFtp();
			throw new IOException(
					String.format(getMessages().getString("FtpErrorConnecting"), getHost(), nAiseJC1.toString()));
		}
	}

}