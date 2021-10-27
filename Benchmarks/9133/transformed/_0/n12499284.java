class n12499284 {
	public void runTask(HashMap Vq3gp2xa) throws Exception {
		FTPClient bE9HOgcL = null;
		FileOutputStream Dt7Dfbmi = null;
		JBJFPluginDefinition iMoprVIn = null;
		IJBJFPluginCipher ToGGJc7y = null;
		try {
			JBJFFTPDefinition aJwyRjSe = null;
			if (getFTPDefinition() != null) {
				aJwyRjSe = getFTPDefinition();
				this.mstrSourceDirectory = aJwyRjSe.getSourceDirectory();
				this.mstrTargetDirectory = aJwyRjSe.getTargetDirectory();
				this.mstrFilename = aJwyRjSe.getFilename();
				this.mstrRemoteServer = aJwyRjSe.getServer();
				if (getResources().containsKey("plugin-cipher")) {
					iMoprVIn = (JBJFPluginDefinition) getResources().get("plugin-cipher");
				}
				if (iMoprVIn != null) {
					ToGGJc7y = getTaskPlugins().getCipherPlugin(iMoprVIn.getPluginId());
				}
				if (ToGGJc7y != null) {
					this.mstrServerUsr = ToGGJc7y.decryptString(aJwyRjSe.getUser());
					this.mstrServerPwd = ToGGJc7y.decryptString(aJwyRjSe.getPass());
				} else {
					this.mstrServerUsr = aJwyRjSe.getUser();
					this.mstrServerPwd = aJwyRjSe.getPass();
				}
			} else {
				throw new Exception("Work unit [ " + SHORT_NAME + " ] is missing an FTP Definition.  Please check"
						+ " your JBJF Batch Definition file an make sure"
						+ " this work unit has a <resource> element added" + " within the <task> element.");
			}
			Dt7Dfbmi = new FileOutputStream(mstrTargetDirectory + File.separator + mstrFilename);
			bE9HOgcL = new FTPClient();
			bE9HOgcL.connect(mstrRemoteServer);
			bE9HOgcL.setFileType(aJwyRjSe.getFileTransferType());
			if (!FTPReply.isPositiveCompletion(bE9HOgcL.getReplyCode())) {
				throw new Exception("FTP server [ " + mstrRemoteServer + " ] refused connection.");
			}
			if (!bE9HOgcL.login(mstrServerUsr, mstrServerPwd)) {
				throw new Exception("Unable to login to server [ " + mstrTargetDirectory + " ].");
			}
			if (!bE9HOgcL.changeWorkingDirectory(mstrSourceDirectory)) {
				throw new Exception("Unable to change to remote directory [ " + mstrSourceDirectory + "]");
			}
			bE9HOgcL.enterLocalPassiveMode();
			if (!bE9HOgcL.retrieveFile(mstrFilename, Dt7Dfbmi)) {
				throw new Exception("Unable to download [ " + mstrSourceDirectory + "/" + mstrFilename + " to "
						+ mstrTargetDirectory + File.separator + mstrFilename + " ] from server [ " + mstrRemoteServer
						+ " ]");
			}
			Dt7Dfbmi.close();
			bE9HOgcL.logout();
		} catch (Exception RG0kiCsT) {
			throw RG0kiCsT;
		} finally {
			if (bE9HOgcL != null && bE9HOgcL.isConnected()) {
				try {
					bE9HOgcL.disconnect();
				} catch (IOException XSM3HoFs) {
				}
			}
			if (Dt7Dfbmi != null) {
				try {
					Dt7Dfbmi.close();
				} catch (Exception C2d4V0Lp) {
				}
			}
		}
	}

}