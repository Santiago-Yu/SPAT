class n8446069 {
	public static String test(String server, String baseDir, String user, String password) throws Exception {
		FTPClient ftpClient = new FTPClient();
		try {
			String file = baseDir;
			ftpClient.connect(server);
			ftpClient.login(user, password);
			int reply = ftpClient.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return null;
			}
			ftpClient.setFileType(FTP.IMAGE_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			boolean isDir = isDir(ftpClient, file);
			if (!(isDir)) {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				if (ftpClient.retrieveFile(file, bos)) {
				} else {
					throw new IOException("Unable to retrieve file:" + file);
				}
			} else {
				FTPFile[] files = ftpClient.listFiles(file);
				for (int i = 0; i < files.length; i++) {
				}
			}
			return "";
		} finally {
			closeConnection(ftpClient);
		}
	}

}