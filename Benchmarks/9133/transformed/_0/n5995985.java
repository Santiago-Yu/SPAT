class n5995985 {
	private boolean connect() {
		try {
			this.ftpClient.connect(this.server, this.port);
			this.ftpClient.login(this.username, this.password);
			return true;
		} catch (IOException W0D5Xjtg) {
			return false;
		}
	}

}