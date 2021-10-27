class n13816650 {
	private synchronized void createFTPConnection() throws RemoteClientException {
		ftpClient = new FTPClient();
		try {
			URL url = fileset.getHostURL();
			PasswordAuthentication passwordAuthentication = fileset.getPasswordAuthentication();
			if (passwordAuthentication == null) {
				passwordAuthentication = anonPassAuth;
			}
			InetAddress inetAddress = InetAddress.getByName(url.getHost());
			if (-1 == url.getPort()) {
				ftpClient.connect(inetAddress);
			} else {
				ftpClient.connect(inetAddress, url.getPort());
			}
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				throw new FTPBrowseException(ftpClient.getReplyString());
			}
			ftpClient.login(passwordAuthentication.getUserName(),
					new StringBuffer().append(passwordAuthentication.getPassword()).toString());
			if (url.getPath().length() > 0) {
				ftpClient.changeWorkingDirectory(url.getPath());
			}
		} catch (UnknownHostException e) {
			throw new RemoteClientException("Host not found.", e);
		} catch (SocketException e) {
			throw new RemoteClientException("Socket cannot be opened.", e);
		} catch (IOException e) {
			throw new RemoteClientException("Socket cannot be opened.", e);
		}
	}

}