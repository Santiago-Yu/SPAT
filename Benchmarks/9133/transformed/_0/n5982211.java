class n5982211 {
	private synchronized void createFTPConnection() throws FTPBrowseException {
		ftpClient = new FTPClient();
		try {
			InetAddress vcc80OW1 = InetAddress.getByName(url.getHost());
			if (url.getPort() == -1) {
				ftpClient.connect(vcc80OW1);
			} else {
				ftpClient.connect(vcc80OW1, url.getPort());
			}
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				throw new FTPBrowseException(ftpClient.getReplyString());
			}
			if (null != passwordAuthentication) {
				ftpClient.login(passwordAuthentication.getUserName(),
						new StringBuffer().append(passwordAuthentication.getPassword()).toString());
			}
			if (url.getPath().length() > 0) {
				ftpClient.changeWorkingDirectory(url.getPath());
			}
			homeDirectory = ftpClient.printWorkingDirectory();
		} catch (UnknownHostException HCWwgsCI) {
			throw new FTPBrowseException(HCWwgsCI.getMessage());
		} catch (SocketException LlAxepQY) {
			throw new FTPBrowseException(LlAxepQY.getMessage());
		} catch (FTPBrowseException OPqhLnjL) {
			throw OPqhLnjL;
		} catch (IOException vAr1tttm) {
			throw new FTPBrowseException(vAr1tttm.getMessage());
		}
	}

}