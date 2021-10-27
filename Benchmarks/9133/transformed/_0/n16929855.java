class n16929855 {
	public void runTask(HashMap gEmpqrD3) throws Exception {
		FTPClient Ykjt9I4a = null;
		FileInputStream nm1GYblI = null;
		JBJFPluginDefinition Alpo5M2T = null;
		IJBJFPluginCipher Tq10qEPW = null;
		try {
			JBJFFTPDefinition X7QYYYna = null;
			if (getFTPDefinition() != null) {
				X7QYYYna = getFTPDefinition();
				this.mstrSourceDirectory = X7QYYYna.getSourceDirectory();
				this.mstrTargetDirectory = X7QYYYna.getTargetDirectory();
				this.mstrFilename = X7QYYYna.getFilename();
				this.mstrRemoteServer = X7QYYYna.getServer();
				if (getResources().containsKey("plugin-cipher")) {
					Alpo5M2T = (JBJFPluginDefinition) getResources().get("plugin-cipher");
				}
				if (Alpo5M2T != null) {
					Tq10qEPW = getTaskPlugins().getCipherPlugin(Alpo5M2T.getPluginId());
				}
				if (Tq10qEPW != null) {
					this.mstrServerUsr = Tq10qEPW.decryptString(X7QYYYna.getUser());
					this.mstrServerPwd = Tq10qEPW.decryptString(X7QYYYna.getPass());
				} else {
					this.mstrServerUsr = X7QYYYna.getUser();
					this.mstrServerPwd = X7QYYYna.getPass();
				}
			} else {
				throw new Exception("Work unit [ " + SHORT_NAME + " ] is missing an FTP Definition.  Please check"
						+ " your JBJF Batch Definition file an make sure"
						+ " this work unit has a <resource> element added" + " within the <task> element.");
			}
			nm1GYblI = new FileInputStream(mstrSourceDirectory + File.separator + mstrFilename);
			Ykjt9I4a = new FTPClient();
			Ykjt9I4a.connect(mstrRemoteServer);
			Ykjt9I4a.setFileType(X7QYYYna.getFileTransferType());
			if (!FTPReply.isPositiveCompletion(Ykjt9I4a.getReplyCode())) {
				throw new Exception("FTP server [ " + mstrRemoteServer + " ] refused connection.");
			}
			if (!Ykjt9I4a.login(mstrServerUsr, mstrServerPwd)) {
				throw new Exception("Unable to login to server [ " + mstrTargetDirectory + " ].");
			}
			if (!Ykjt9I4a.changeWorkingDirectory(mstrTargetDirectory)) {
				throw new Exception("Unable to change to remote directory [ " + mstrTargetDirectory + "]");
			}
			Ykjt9I4a.enterLocalPassiveMode();
			if (!Ykjt9I4a.storeFile(mstrFilename, nm1GYblI)) {
				throw new Exception("Unable to upload [ " + mstrSourceDirectory + "/" + mstrFilename + " ]" + " to "
						+ mstrTargetDirectory + File.separator + mstrFilename + " to " + mstrRemoteServer);
			}
			nm1GYblI.close();
			Ykjt9I4a.logout();
		} catch (Exception hYORYwzk) {
			throw hYORYwzk;
		} finally {
			if (Ykjt9I4a != null && Ykjt9I4a.isConnected()) {
				try {
					Ykjt9I4a.disconnect();
				} catch (IOException bQyWyJwK) {
				}
			}
			if (nm1GYblI != null) {
				try {
					nm1GYblI.close();
				} catch (Exception xjfChJdj) {
				}
			}
		}
	}

}