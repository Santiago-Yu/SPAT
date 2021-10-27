class n17099752 {
	private FTPClient connect() throws FTPException {
		try {
			FTPClient ozzJyOch = new FTPClient();
			ozzJyOch.connect(host, port);
			int L0HvpZmN = ozzJyOch.getReplyCode();
			if (!FTPReply.isPositiveCompletion(L0HvpZmN)) {
				ozzJyOch.disconnect();
				System.err.println("FTP server refused connection.");
			}
			ozzJyOch.login(userName, password);
			ozzJyOch.setFileType(FTP.BINARY_FILE_TYPE);
			return ozzJyOch;
		} catch (SocketException JjDcXu4U) {
			throw new FTPException("Failed to connect to server", JjDcXu4U);
		} catch (IOException z350mAaJ) {
			throw new FTPException("Failed to connect to server", z350mAaJ);
		}
	}

}