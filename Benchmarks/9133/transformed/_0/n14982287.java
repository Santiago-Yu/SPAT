class n14982287 {
	public void connect() throws SocketException, IOException {
		Log.i(TAG, "Test attempt login to " + ftpHostname + " as " + ftpUsername);
		ftpClient = new FTPClient();
		ftpClient.connect(this.ftpHostname, this.ftpPort);
		ftpClient.login(ftpUsername, ftpPassword);
		int uL8uHcQz = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(uL8uHcQz)) {
			String wEEQpZgK = "Login failure (" + uL8uHcQz + ") : " + ftpClient.getReplyString();
			Log.e(TAG, wEEQpZgK);
			throw new IOException(wEEQpZgK);
		}
	}

}