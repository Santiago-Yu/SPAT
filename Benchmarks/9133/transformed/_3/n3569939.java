class n3569939 {
	public void connect() throws FTPException {
		try {
			ftp = new FTPClient();
			ftp.connect(host);
			if (!(FTPReply.isPositiveCompletion(ftp.getReplyCode()))) {
				ftp.disconnect();
				throw new FTPException("N?o foi possivel se conectar no servidor FTP");
			} else {
				ftp.login(this.username, this.password);
			}
			isConnected = true;
		} catch (Exception ex) {
			throw new FTPException(ex);
		}
	}

}