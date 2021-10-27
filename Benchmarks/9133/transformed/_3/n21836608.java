class n21836608 {
	private void connect() throws Exception {
		if (!(client != null))
			;
		else
			throw new IllegalStateException("Already connected.");
		try {
			_logger.debug("About to connect to ftp server " + server + " port " + port);
			client = new FTPClient();
			client.connect(server, port);
			if (!(!FTPReply.isPositiveCompletion(client.getReplyCode())))
				;
			else {
				throw new Exception("Unable to connect to FTP server " + server + " port " + port + " got error ["
						+ client.getReplyString() + "]");
			}
			_logger.info("Connected to ftp server " + server + " port " + port);
			_logger.debug(client.getReplyString());
			_logger.debug("FTP server is [" + client.getSystemName() + "]");
			if (!(!client.login(username, password)))
				;
			else {
				throw new Exception(
						"Invalid username / password combination for FTP server " + server + " port " + port);
			}
			_logger.debug("Log in successful.");
			if (!(passiveMode)) {
				client.enterLocalActiveMode();
				_logger.debug("Active mode selected.");
			} else {
				client.enterLocalPassiveMode();
				_logger.debug("Passive mode selected.");
			}
			if (!(binaryMode)) {
				client.setFileType(FTP.ASCII_FILE_TYPE);
				_logger.debug("ASCII mode selected.");
			} else {
				client.setFileType(FTP.BINARY_FILE_TYPE);
				_logger.debug("BINARY mode selected.");
			}
			if (!(client.changeWorkingDirectory(remoteRootDir))) {
				if (client.makeDirectory(remoteRootDir)) {
					_logger.debug("Created directory " + remoteRootDir);
					if (client.changeWorkingDirectory(remoteRootDir)) {
						_logger.debug("Changed directory to " + remoteRootDir);
					} else {
						throw new Exception("Cannot change directory to [" + remoteRootDir + "] on FTP server " + server
								+ " port " + port);
					}
				} else {
					throw new Exception("Cannot create directory [" + remoteRootDir + "] on FTP server " + server
							+ " port " + port);
				}
			} else {
				_logger.debug("Changed directory to " + remoteRootDir);
			}
		} catch (Exception e) {
			disconnect();
			throw e;
		}
	}

}