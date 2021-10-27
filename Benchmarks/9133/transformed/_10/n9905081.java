class n9905081 {
	public boolean connect(String host, String userName, String password) throws IOException, UnknownHostException {
		try {
			if (ftpClient != null) {
				if (ftpClient.isConnected()) {
					ftpClient.disconnect();
				}
			}
			boolean success = false;
			ftpClient = new FTPClient();
			ftpClient.connect(host);
			int reply = ftpClient.getReplyCode();
			if (FTPReply.isPositiveCompletion(reply)) {
				success = ftpClient.login(userName, password);
			}
			if (!success) {
				ftpClient.disconnect();
			}
			return success;
		} catch (Exception ex) {
			throw new IOException(ex.getMessage());
		}
	}

}