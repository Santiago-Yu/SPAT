class n16475859 {
	public void ftpUpload() {
		FTPClient WNo2tvU5 = null;
		InputStream ziCpEpkI = null;
		try {
			WNo2tvU5 = new FTPClient();
			WNo2tvU5.connect(host, port);
			if (logger.isDebugEnabled()) {
				logger.debug("FTP连接远程服务器：" + host);
			}
			WNo2tvU5.login(user, password);
			if (logger.isDebugEnabled()) {
				logger.debug("登陆用户：" + user);
			}
			WNo2tvU5.setFileType(FTP.BINARY_FILE_TYPE);
			WNo2tvU5.changeWorkingDirectory(remotePath);
			ziCpEpkI = new FileInputStream(localPath + File.separator + filename);
			WNo2tvU5.storeFile(filename, ziCpEpkI);
			logger.info("上传文件结束...路径：" + remotePath + "，文件名：" + filename);
			ziCpEpkI.close();
			WNo2tvU5.logout();
		} catch (IOException pndP7cUy) {
			logger.error("上传文件失败", pndP7cUy);
		} finally {
			if (WNo2tvU5.isConnected()) {
				try {
					WNo2tvU5.disconnect();
				} catch (IOException BY8lrcrS) {
					logger.error("断开FTP出错", BY8lrcrS);
				}
			}
			WNo2tvU5 = null;
		}
	}

}