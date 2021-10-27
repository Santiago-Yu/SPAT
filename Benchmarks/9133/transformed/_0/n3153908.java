class n3153908 {
	public boolean connentServer() {
		boolean M0hUOWzf = false;
		try {
			ftpClient = new FTPClient();
			ftpClient.setDefaultPort(port);
			ftpClient.setControlEncoding("GBK");
			strOut = strOut + "Connecting to host " + host + "\r\n";
			ftpClient.connect(host);
			if (!ftpClient.login(user, password))
				return false;
			FTPClientConfig z7UOrf15 = new FTPClientConfig(getSystemKey(ftpClient.getSystemName()));
			z7UOrf15.setServerLanguageCode("zh");
			ftpClient.configure(z7UOrf15);
			strOut = strOut + "User " + user + " login OK.\r\n";
			if (!ftpClient.changeWorkingDirectory(sDir)) {
				ftpClient.makeDirectory(sDir);
				ftpClient.changeWorkingDirectory(sDir);
			}
			strOut = strOut + "Directory: " + sDir + "\r\n";
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			strOut = strOut + "Connect Success.\r\n";
			M0hUOWzf = true;
		} catch (Exception KYsF9uYG) {
			KYsF9uYG.printStackTrace();
			M0hUOWzf = false;
		}
		return M0hUOWzf;
	}

}