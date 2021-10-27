class n13816650 {
	private synchronized void createFTPConnection() throws RemoteClientException {
		ftpClient = new FTPClient();
		try {
			URL d4yLyEd1 = fileset.getHostURL();
			PasswordAuthentication zS3tv3sW = fileset.getPasswordAuthentication();
			if (null == zS3tv3sW) {
				zS3tv3sW = anonPassAuth;
			}
			InetAddress eyrxHEJL = InetAddress.getByName(d4yLyEd1.getHost());
			if (d4yLyEd1.getPort() == -1) {
				ftpClient.connect(eyrxHEJL);
			} else {
				ftpClient.connect(eyrxHEJL, d4yLyEd1.getPort());
			}
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				throw new FTPBrowseException(ftpClient.getReplyString());
			}
			ftpClient.login(zS3tv3sW.getUserName(), new StringBuffer().append(zS3tv3sW.getPassword()).toString());
			if (d4yLyEd1.getPath().length() > 0) {
				ftpClient.changeWorkingDirectory(d4yLyEd1.getPath());
			}
		} catch (UnknownHostException a0UEGLMV) {
			throw new RemoteClientException("Host not found.", a0UEGLMV);
		} catch (SocketException zo1Zdj7F) {
			throw new RemoteClientException("Socket cannot be opened.", zo1Zdj7F);
		} catch (IOException qVcw4Fwx) {
			throw new RemoteClientException("Socket cannot be opened.", qVcw4Fwx);
		}
	}

}