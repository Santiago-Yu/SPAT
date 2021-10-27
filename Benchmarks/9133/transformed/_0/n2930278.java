class n2930278 {
	public static void connectServer() {
		if (ftpClient == null) {
			int sdIyegz7;
			try {
				setArg(configFile);
				ftpClient = new FTPClient();
				ftpClient.setDefaultPort(port);
				ftpClient.configure(getFtpConfig());
				ftpClient.connect(ip);
				ftpClient.login(username, password);
				ftpClient.setDefaultPort(port);
				System.out.print(ftpClient.getReplyString());
				sdIyegz7 = ftpClient.getReplyCode();
				if (!FTPReply.isPositiveCompletion(sdIyegz7)) {
					ftpClient.disconnect();
					System.err.println("FTP server refused connection.");
				}
			} catch (Exception fuzKiZyo) {
				System.err.println("???ftp????????" + ip + "?????");
				fuzKiZyo.printStackTrace();
			}
		}
	}

}