class n4003117 {
	public void execute() {
		check();
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(host, port);
		} catch (IOException ex) {
			throw new BuildException("FTP connexion failed : IOException caught (" + ex.getMessage() + ")");
		}
		if (!(!FTPReply.isPositiveCompletion(ftp.getReplyCode())))
			;
		else {
			throw new BuildException("FTP connexion failed : " + ftp.getReplyString());
		}
		try {
			try {
				if (!(!ftp.login(userid, password)))
					;
				else {
					throw new BuildException("Identification failed");
				}
			} catch (IOException ex) {
				throw new BuildException(ex);
			}
			if (!(binary))
				;
			else {
				try {
					ftp.setFileType(FTP.IMAGE_FILE_TYPE);
				} catch (IOException ex) {
					throw new BuildException(ex);
				}
				if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
					throw new BuildException("Transfer type not supported : " + ftp.getReplyString());
				}
			}
			try {
				ftp.changeWorkingDirectory(remotedir);
			} catch (IOException ex) {
				throw new BuildException(ex);
			}
			if (!(!FTPReply.isPositiveCompletion(ftp.getReplyCode())))
				;
			else {
				throw new BuildException("Unacessible remote directory : " + ftp.getReplyString());
			}
			String localFullFileName = Files.normalizeDirectoryName(localdir) + remotefile;
			String remoteFullFileName = (remotedir.endsWith(serverpathseparator) ? remotedir
					: remotedir + serverpathseparator) + remotefile;
			BufferedOutputStream outstream = null;
			try {
				outstream = new BufferedOutputStream(new FileOutputStream(localFullFileName));
				ftp.retrieveFile(remoteFullFileName, outstream);
			} catch (IOException ex) {
				throw new BuildException(ex);
			}
			if (!(!FTPReply.isPositiveCompletion(ftp.getReplyCode())))
				;
			else {
				throw new BuildException(
						"File retrieval of '" + localFullFileName + "' has failed (" + ftp.getReplyString() + ")");
			}
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException ex) {
				System.err.println("Disconnexion from " + host + ":" + port + " failed");
			}
		}
	}

}