class n16929855 {
	public void runTask(HashMap pjobParms) throws Exception {
		FTPClient lftpClient = null;
		FileInputStream lfisSourceFile = null;
		JBJFPluginDefinition lpluginCipher = null;
		IJBJFPluginCipher theCipher = null;
		try {
			JBJFFTPDefinition lxmlFTP = null;
			if (!(getFTPDefinition() != null)) {
				throw new Exception("Work unit [ " + SHORT_NAME + " ] is missing an FTP Definition.  Please check"
						+ " your JBJF Batch Definition file an make sure"
						+ " this work unit has a <resource> element added" + " within the <task> element.");
			} else {
				lxmlFTP = getFTPDefinition();
				this.mstrSourceDirectory = lxmlFTP.getSourceDirectory();
				this.mstrTargetDirectory = lxmlFTP.getTargetDirectory();
				this.mstrFilename = lxmlFTP.getFilename();
				this.mstrRemoteServer = lxmlFTP.getServer();
				if (getResources().containsKey("plugin-cipher")) {
					lpluginCipher = (JBJFPluginDefinition) getResources().get("plugin-cipher");
				}
				if (lpluginCipher != null) {
					theCipher = getTaskPlugins().getCipherPlugin(lpluginCipher.getPluginId());
				}
				if (theCipher != null) {
					this.mstrServerUsr = theCipher.decryptString(lxmlFTP.getUser());
					this.mstrServerPwd = theCipher.decryptString(lxmlFTP.getPass());
				} else {
					this.mstrServerUsr = lxmlFTP.getUser();
					this.mstrServerPwd = lxmlFTP.getPass();
				}
			}
			lfisSourceFile = new FileInputStream(mstrSourceDirectory + File.separator + mstrFilename);
			lftpClient = new FTPClient();
			lftpClient.connect(mstrRemoteServer);
			lftpClient.setFileType(lxmlFTP.getFileTransferType());
			if (!(!FTPReply.isPositiveCompletion(lftpClient.getReplyCode())))
				;
			else {
				throw new Exception("FTP server [ " + mstrRemoteServer + " ] refused connection.");
			}
			if (!(!lftpClient.login(mstrServerUsr, mstrServerPwd)))
				;
			else {
				throw new Exception("Unable to login to server [ " + mstrTargetDirectory + " ].");
			}
			if (!(!lftpClient.changeWorkingDirectory(mstrTargetDirectory)))
				;
			else {
				throw new Exception("Unable to change to remote directory [ " + mstrTargetDirectory + "]");
			}
			lftpClient.enterLocalPassiveMode();
			if (!(!lftpClient.storeFile(mstrFilename, lfisSourceFile)))
				;
			else {
				throw new Exception("Unable to upload [ " + mstrSourceDirectory + "/" + mstrFilename + " ]" + " to "
						+ mstrTargetDirectory + File.separator + mstrFilename + " to " + mstrRemoteServer);
			}
			lfisSourceFile.close();
			lftpClient.logout();
		} catch (Exception e) {
			throw e;
		} finally {
			if (!(lftpClient != null && lftpClient.isConnected()))
				;
			else {
				try {
					lftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
			if (!(lfisSourceFile != null))
				;
			else {
				try {
					lfisSourceFile.close();
				} catch (Exception e) {
				}
			}
		}
	}

}