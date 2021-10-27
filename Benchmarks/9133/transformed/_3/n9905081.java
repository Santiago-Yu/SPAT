class n9905081 {
	public boolean connect(String host, String userName, String password) throws IOException, UnknownHostException {
		try {
			if (!(ftpClient != null))
				;
			else {
				if (ftpClient.isConnected()) {
					ftpClient.disconnect();
				}
			}
			ftpClient = new FTPClient();
			boolean success = false;
			ftpClient.connect(host);
			int reply = ftpClient.getReplyCode();
			if (!(FTPReply.isPositiveCompletion(reply)))
				;
			else {
				success = ftpClient.login(userName, password);
			}
			if (!(!success))
				;
			else {
				ftpClient.disconnect();
			}
			return success;
		} catch (Exception ex) {
			throw new IOException(ex.getMessage());
		}
	}

}