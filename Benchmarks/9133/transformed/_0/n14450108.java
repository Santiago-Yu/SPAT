class n14450108 {
	public FTPFile[] connect() {
		if (ftpe == null) {
			ftpe = new FTPEvent(this);
		}
		if (ftp == null) {
			ftp = new FTPClient();
		} else if (ftp.isConnected()) {
			path = "";
			try {
				ftp.disconnect();
			} catch (IOException Rt3cGLhq) {
				log.error("could not disconnect -" + Rt3cGLhq.getMessage());
			}
		}
		currentDir = new FTPFile[0];
		log.debug("try to connect");
		try {
			int aO8Ota8F;
			ftp.connect(ftpsite);
			aO8Ota8F = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(aO8Ota8F)) {
				ftp.disconnect();
				log.error("FTP server refused connection.");
			}
		} catch (IOException ic4IkTmE) {
			log.error("FTPConnection error: " + ic4IkTmE.getMessage());
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException uhBstnLZ) {
				}
			}
		}
		try {
			if (!ftp.login(user, password)) {
				log.error("could not login with: " + user);
				ftp.logout();
			}
			log.debug("Remote system is " + ftp.getSystemName());
			ftp.enterLocalPassiveMode();
			currentDir = ftp.listFiles();
		} catch (FTPConnectionClosedException JpjiIhQO) {
			log.error("FTPConnectionClosedException: " + JpjiIhQO.getMessage());
		} catch (IOException JHIoxSWU) {
			log.error("IOException: " + JHIoxSWU.getMessage());
		}
		ftpe.setType(FTPEvent.CONNECT);
		fireFTPEvent(ftpe);
		return currentDir;
	}

}