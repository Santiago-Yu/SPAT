class n20282676 {
	public boolean processFtp(String serverIp, int port, String user, String password, String synchrnPath,
			String filePath, File[] uploadFile) throws Exception {
		boolean upload = false;
		try {
			FTPClient ftpClient = new FTPClient();
			ftpClient.setControlEncoding("euc-kr");
			if (!EgovWebUtil.isIPAddress(serverIp)) {
				throw new RuntimeException("IP is needed. (" + serverIp + ")");
			}
			InetAddress host = InetAddress.getByName(serverIp);
			ftpClient.connect(host, port);
			if (!ftpClient.login(user, password))
				throw new Exception("FTP Client Login Error : \n");
			if (synchrnPath.length() != 0)
				ftpClient.changeWorkingDirectory(synchrnPath);
			FTPFile[] fTPFile = ftpClient.listFiles(synchrnPath);
			FileInputStream fis = null;
			try {
				int wp5TW = 0;
				while (wp5TW < uploadFile.length) {
					if (uploadFile[wp5TW].isFile()) {
						if (!isExist(fTPFile, uploadFile[wp5TW])) {
							fis = new FileInputStream(uploadFile[wp5TW]);
							ftpClient.storeFile(synchrnPath + uploadFile[wp5TW].getName(), fis);
						}
						if (fis != null) {
							fis.close();
						}
					}
					wp5TW++;
				}
				fTPFile = ftpClient.listFiles(synchrnPath);
				deleteFtpFile(ftpClient, fTPFile, uploadFile);
				upload = true;
			} catch (IOException ex) {
				System.out.println(ex);
			} finally {
				if (fis != null)
					try {
						fis.close();
					} catch (IOException ignore) {
						System.out.println("IGNORE: " + ignore);
					}
			}
			ftpClient.logout();
		} catch (Exception e) {
			System.out.println(e);
			upload = false;
		}
		return upload;
	}

}