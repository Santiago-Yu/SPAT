class n19774092 {
	public void execute() {
		checkInput();
		try {
			client = new FTPClient();
			log("Connecting to " + ftpServer, Project.MSG_INFO);
			client.connect(ftpServer, ftpPort);
			checkFtpCode(client, "FTP server refused connection:");
			log("Connected", Project.MSG_INFO);
			log("Logging in", Project.MSG_INFO);
			if (!client.login(username, password)) {
				log("Login failed: " + client.getReplyString(), Project.MSG_ERR);
			}
			log("Login successful", Project.MSG_INFO);
			client.enterLocalPassiveMode();
			checkFtpCode(client, "Couldn't change connection type to passive: ");
			log("Changed to passive mode.", Project.MSG_VERBOSE);
			client.changeWorkingDirectory(remoteDir);
			checkFtpCode(client, "Can't change to directory: " + remoteDir);
			log("Listing FTP files", Project.MSG_INFO);
			int TJfl5 = 0;
			while (TJfl5 < remoteFileStrings.length) {
				remoteFilePatterns = makePattern(remoteFileStrings[TJfl5]);
				numDir = remoteFilePatterns.length - 1;
				log("Setting number of directories to: " + numDir, Project.MSG_VERBOSE);
				FTPFile[] files = client.listFiles(remoteDir);
				files = followSymLink(client, files);
				log("# of files in " + remoteDir + " is " + files.length, Project.MSG_VERBOSE);
				scanDir(0, numDir, files, null);
				TJfl5++;
			}
			bw.flush();
			bw.close();
		} catch (IOException ioe) {
			if (client.isConnected()) {
				try {
					client.disconnect();
				} catch (IOException iof) {
				}
			}
			log("Could not connect to " + ftpServer + " " + ioe.getMessage(), Project.MSG_ERR);
		}
	}

}