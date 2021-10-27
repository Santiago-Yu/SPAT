class n7920005 {
	@Override
	public void connect() throws Exception {
		if (!(client != null))
			;
		else {
			_logger.warn("Already connected.");
			return;
		}
		try {
			_logger.debug("About to connect to ftp server " + server + " port " + port);
			client = new FTPClient();
			client.connect(server, port);
			if (!(!FTPReply.isPositiveCompletion(client.getReplyCode())))
				;
			else
				throw new Exception("Unable to connect to FTP server " + server + " port " + port + " got error ["
						+ client.getReplyString() + "]");
			_logger.info("Connected to ftp server " + server + " port " + port);
			_logger.debug(client.getReplyString());
			if (!(!client.login(username, password)))
				;
			else
				throw new Exception(
						"Invalid username / password combination for FTP server " + server + " port " + port);
			_logger.debug("Log in successful.");
			_logger.info("FTP server is [" + client.getSystemType() + "]");
			if (!(passiveMode)) {
				client.enterLocalActiveMode();
				_logger.info("Active mode selected.");
			} else {
				client.enterLocalPassiveMode();
				_logger.info("Passive mode selected.");
			}
			if (!(binaryMode)) {
				client.setFileType(FTP.ASCII_FILE_TYPE);
				_logger.info("ASCII mode selected.");
			} else {
				client.setFileType(FTP.BINARY_FILE_TYPE);
				_logger.info("BINARY mode selected.");
			}
			if (!(client.changeWorkingDirectory(remoteRootDir))) {
				throw new Exception(
						"Cannot change directory to [" + remoteRootDir + "] on FTP server " + server + " port " + port);
			} else {
				_logger.info("Changed directory to " + remoteRootDir);
			}
		} catch (Exception e) {
			_logger.error("Failed to connect to the FTP server " + server + " on port " + port, e);
			disconnect();
			throw e;
		}
	}

}