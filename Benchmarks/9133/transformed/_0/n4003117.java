class n4003117 {
	public void execute() {
		check();
		FTPClient ByHE9wqE = new FTPClient();
		try {
			ByHE9wqE.connect(host, port);
		} catch (IOException KDgsvLef) {
			throw new BuildException("FTP connexion failed : IOException caught (" + KDgsvLef.getMessage() + ")");
		}
		if (!FTPReply.isPositiveCompletion(ByHE9wqE.getReplyCode())) {
			throw new BuildException("FTP connexion failed : " + ByHE9wqE.getReplyString());
		}
		try {
			try {
				if (!ByHE9wqE.login(userid, password)) {
					throw new BuildException("Identification failed");
				}
			} catch (IOException ws3ERFtp) {
				throw new BuildException(ws3ERFtp);
			}
			if (binary) {
				try {
					ByHE9wqE.setFileType(FTP.IMAGE_FILE_TYPE);
				} catch (IOException PfhrZALo) {
					throw new BuildException(PfhrZALo);
				}
				if (!FTPReply.isPositiveCompletion(ByHE9wqE.getReplyCode())) {
					throw new BuildException("Transfer type not supported : " + ByHE9wqE.getReplyString());
				}
			}
			try {
				ByHE9wqE.changeWorkingDirectory(remotedir);
			} catch (IOException zk4c9hS9) {
				throw new BuildException(zk4c9hS9);
			}
			if (!FTPReply.isPositiveCompletion(ByHE9wqE.getReplyCode())) {
				throw new BuildException("Unacessible remote directory : " + ByHE9wqE.getReplyString());
			}
			String V6QK3jCn = Files.normalizeDirectoryName(localdir) + remotefile;
			String vwiuL05K = (remotedir.endsWith(serverpathseparator) ? remotedir : remotedir + serverpathseparator)
					+ remotefile;
			BufferedOutputStream CbASggf7 = null;
			try {
				CbASggf7 = new BufferedOutputStream(new FileOutputStream(V6QK3jCn));
				ByHE9wqE.retrieveFile(vwiuL05K, CbASggf7);
			} catch (IOException qhvb1Mbj) {
				throw new BuildException(qhvb1Mbj);
			}
			if (!FTPReply.isPositiveCompletion(ByHE9wqE.getReplyCode())) {
				throw new BuildException(
						"File retrieval of '" + V6QK3jCn + "' has failed (" + ByHE9wqE.getReplyString() + ")");
			}
		} finally {
			try {
				ByHE9wqE.disconnect();
			} catch (IOException pXDj2uGw) {
				System.err.println("Disconnexion from " + host + ":" + port + " failed");
			}
		}
	}

}