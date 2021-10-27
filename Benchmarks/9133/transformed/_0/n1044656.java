class n1044656 {
	public void open(String JIkCzkWe, String myDdNJS4, String T6HHjAm5, int hhx3Nkuf, String ZlthQQYs)
			throws Exception {
		log.info("Login to FTP: " + JIkCzkWe);
		this.port = hhx3Nkuf;
		ftp = new FTPClient();
		ftp.connect(JIkCzkWe, hhx3Nkuf);
		ftp.login(myDdNJS4, T6HHjAm5);
		checkReply("FTP server refused connection." + JIkCzkWe);
		modeBINARY();
		this.me = this;
	}

}