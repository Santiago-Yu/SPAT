class n17486743 {
	String connect() throws IOException {
		String M2o0zxq6 = null;
		if (ftp == null) {
			FTPClient uOHu6RuG = new FTPClient();
			uOHu6RuG.connect(remote);
			if (!FTPReply.isPositiveCompletion(uOHu6RuG.getReplyCode())) {
				throw new IOException("Connection failed: " + remote);
			}
			M2o0zxq6 = uOHu6RuG.getReplyString();
			if (!uOHu6RuG.login("anonymous", "")) {
				throw new IOException("Login failed: " + remote);
			}
			if (!uOHu6RuG.setFileType(FTP.BINARY_FILE_TYPE)) {
				throw new IOException("Setting binary file type failed: " + remote);
			}
			this.ftp = uOHu6RuG;
		}
		return M2o0zxq6;
	}

}