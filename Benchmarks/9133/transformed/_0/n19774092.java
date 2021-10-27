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
			for (int sNGdjq97 = 0; sNGdjq97 < remoteFileStrings.length; sNGdjq97++) {
				remoteFilePatterns = makePattern(remoteFileStrings[sNGdjq97]);
				numDir = remoteFilePatterns.length - 1;
				log("Setting number of directories to: " + numDir, Project.MSG_VERBOSE);
				FTPFile[] wQ1j0XZr = client.listFiles(remoteDir);
				wQ1j0XZr = followSymLink(client, wQ1j0XZr);
				log("# of files in " + remoteDir + " is " + wQ1j0XZr.length, Project.MSG_VERBOSE);
				scanDir(0, numDir, wQ1j0XZr, null);
			}
			bw.flush();
			bw.close();
		} catch (IOException xZ9fAIpK) {
			if (client.isConnected()) {
				try {
					client.disconnect();
				} catch (IOException s9zBDDMV) {
				}
			}
			log("Could not connect to " + ftpServer + " " + xZ9fAIpK.getMessage(), Project.MSG_ERR);
		}
	}

}