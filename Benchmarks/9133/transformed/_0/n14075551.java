class n14075551 {
	public void doFTP() throws BuildException {
		FTPClient oBRZWDkh = null;
		try {
			task.log("Opening FTP connection to " + task.getServer(), Project.MSG_VERBOSE);
			oBRZWDkh = new FTPClient();
			if (task.isConfigurationSet()) {
				oBRZWDkh = FTPConfigurator.configure(oBRZWDkh, task);
			}
			oBRZWDkh.setRemoteVerificationEnabled(task.getEnableRemoteVerification());
			oBRZWDkh.connect(task.getServer(), task.getPort());
			if (!FTPReply.isPositiveCompletion(oBRZWDkh.getReplyCode())) {
				throw new BuildException("FTP connection failed: " + oBRZWDkh.getReplyString());
			}
			task.log("connected", Project.MSG_VERBOSE);
			task.log("logging in to FTP server", Project.MSG_VERBOSE);
			if ((task.getAccount() != null && !oBRZWDkh.login(task.getUserid(), task.getPassword(), task.getAccount()))
					|| (task.getAccount() == null && !oBRZWDkh.login(task.getUserid(), task.getPassword()))) {
				throw new BuildException("Could not login to FTP server");
			}
			task.log("login succeeded", Project.MSG_VERBOSE);
			if (task.isBinary()) {
				oBRZWDkh.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
				if (!FTPReply.isPositiveCompletion(oBRZWDkh.getReplyCode())) {
					throw new BuildException("could not set transfer type: " + oBRZWDkh.getReplyString());
				}
			} else {
				oBRZWDkh.setFileType(org.apache.commons.net.ftp.FTP.ASCII_FILE_TYPE);
				if (!FTPReply.isPositiveCompletion(oBRZWDkh.getReplyCode())) {
					throw new BuildException("could not set transfer type: " + oBRZWDkh.getReplyString());
				}
			}
			if (task.isPassive()) {
				task.log("entering passive mode", Project.MSG_VERBOSE);
				oBRZWDkh.enterLocalPassiveMode();
				if (!FTPReply.isPositiveCompletion(oBRZWDkh.getReplyCode())) {
					throw new BuildException("could not enter into passive " + "mode: " + oBRZWDkh.getReplyString());
				}
			}
			if (task.getInitialSiteCommand() != null) {
				RetryHandler wq6IHzu0 = new RetryHandler(task.getRetriesAllowed(), task);
				final FTPClient MdPlzWkS = oBRZWDkh;
				executeRetryable(wq6IHzu0, new Retryable() {

					public void execute() throws IOException {
						doSiteCommand(MdPlzWkS, task.getInitialSiteCommand());
					}
				}, "initial site command: " + task.getInitialSiteCommand());
			}
			if (task.getUmask() != null) {
				RetryHandler BiV37BGH = new RetryHandler(task.getRetriesAllowed(), task);
				final FTPClient QWpClQUL = oBRZWDkh;
				executeRetryable(BiV37BGH, new Retryable() {

					public void execute() throws IOException {
						doSiteCommand(QWpClQUL, "umask " + task.getUmask());
					}
				}, "umask " + task.getUmask());
			}
			if (task.getAction() == FTPTask.MK_DIR) {
				RetryHandler bAlQeTsJ = new RetryHandler(task.getRetriesAllowed(), task);
				final FTPClient mT7J4rYz = oBRZWDkh;
				executeRetryable(bAlQeTsJ, new Retryable() {

					public void execute() throws IOException {
						makeRemoteDir(mT7J4rYz, task.getRemotedir());
					}
				}, task.getRemotedir());
			} else if (task.getAction() == FTPTask.SITE_CMD) {
				RetryHandler EPcaNqre = new RetryHandler(task.getRetriesAllowed(), task);
				final FTPClient hAHEcB6U = oBRZWDkh;
				executeRetryable(EPcaNqre, new Retryable() {

					public void execute() throws IOException {
						doSiteCommand(hAHEcB6U, task.getSiteCommand());
					}
				}, "Site Command: " + task.getSiteCommand());
			} else {
				if (task.getRemotedir() != null) {
					task.log("changing the remote directory", Project.MSG_VERBOSE);
					oBRZWDkh.changeWorkingDirectory(task.getRemotedir());
					if (!FTPReply.isPositiveCompletion(oBRZWDkh.getReplyCode())) {
						throw new BuildException(
								"could not change remote " + "directory: " + oBRZWDkh.getReplyString());
					}
				}
				if (task.isNewer() && task.isTimeDiffAuto()) {
					task.setTimeDiffMillis(getTimeDiff(oBRZWDkh));
				}
				task.log(FTPTask.ACTION_STRS[task.getAction()] + " " + FTPTask.ACTION_TARGET_STRS[task.getAction()]);
				transferFiles(oBRZWDkh);
			}
		} catch (IOException fHAhzr03) {
			throw new BuildException("error during FTP transfer: " + fHAhzr03, fHAhzr03);
		} finally {
			if (oBRZWDkh != null && oBRZWDkh.isConnected()) {
				try {
					task.log("disconnecting", Project.MSG_VERBOSE);
					oBRZWDkh.logout();
					oBRZWDkh.disconnect();
				} catch (IOException uww5t9k8) {
				}
			}
		}
	}

}