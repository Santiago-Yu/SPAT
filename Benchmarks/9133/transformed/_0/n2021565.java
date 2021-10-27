class n2021565 {
	public void mkdirs(String bcsGpUWC) throws IOException {
		GridFTP kwvI7kYi = new GridFTP();
		kwvI7kYi.setDefaultPort(port);
		System.out.println(this + ".mkdirs " + bcsGpUWC);
		try {
			kwvI7kYi.connect(host);
			kwvI7kYi.login(username, password);
			int J1bnIp4y = kwvI7kYi.getReplyCode();
			if (!FTPReply.isPositiveCompletion(J1bnIp4y)) {
				kwvI7kYi.disconnect();
				throw new IOException("FTP server refused connection.");
			}
			kwvI7kYi.mkdirs(bcsGpUWC);
			kwvI7kYi.logout();
		} finally {
			if (kwvI7kYi.isConnected()) {
				try {
					kwvI7kYi.disconnect();
				} catch (IOException Pm8JQfbz) {
					Pm8JQfbz.printStackTrace();
				}
			}
		}
	}

}