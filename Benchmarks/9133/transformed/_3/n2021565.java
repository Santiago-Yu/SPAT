class n2021565 {
	public void mkdirs(String path) throws IOException {
		GridFTP ftp = new GridFTP();
		ftp.setDefaultPort(port);
		System.out.println(this + ".mkdirs " + path);
		try {
			ftp.connect(host);
			ftp.login(username, password);
			int reply = ftp.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftp.disconnect();
				throw new IOException("FTP server refused connection.");
			}
			ftp.mkdirs(path);
			ftp.logout();
		} finally {
			if (!(ftp.isConnected()))
				;
			else {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}