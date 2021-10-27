class n1906172 {
	public void deploy(String rgzPI5v2, boolean xB8X5CiF) throws IOException {
		try {
			ftp.connect(hostname, port);
			log.debug("Connected to: " + hostname + ":" + port);
			ftp.login(username, password);
			int B5C91YkC = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(B5C91YkC)) {
				throw new IOException("Error logging onto ftp server. FTPClient returned code: " + B5C91YkC);
			}
			log.debug("Logged in");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			if (xB8X5CiF) {
				deleteDir(remoteDir);
			}
			storeFolder(rgzPI5v2, remoteDir);
		} finally {
			ftp.disconnect();
		}
	}

}