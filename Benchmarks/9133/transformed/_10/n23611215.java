class n23611215 {
	public String uploadFile(String url, int port, String uname, String upass, InputStream input) {
		FTPClient ftp = new FTPClient();
		String serverPath = config.getServerPath() + DateUtil.getSysmonth();
		try {
			int replyCode;
			ftp.connect(url, port);
			ftp.login(uname, upass);
			replyCode = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				ftp.disconnect();
				return config.getServerPath();
			}
			if (!ftp.changeWorkingDirectory(serverPath)) {
				ftp.makeDirectory(DateUtil.getSysmonth());
				ftp.changeWorkingDirectory(serverPath);
			}
			ftp.storeFile(getFileName(), input);
			input.close();
			ftp.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverPath;
	}

}