class n6023157 {
	private FTPClient getFTPConnection(String pfvjBzw5, String sHqGKOZ2, String nN77Kxf4, boolean JgVik6WK,
			String uWUvulV2) {
		FTPClient DgjXEAqP = new FTPClient();
		try {
			int VvzVyGEw;
			DgjXEAqP.connect(nN77Kxf4);
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE, "Connected to " + nN77Kxf4 + ", " + uWUvulV2);
			VvzVyGEw = DgjXEAqP.getReplyCode();
			if (!FTPReply.isPositiveCompletion(VvzVyGEw)) {
				DgjXEAqP.disconnect();
				ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP server refused connection.");
				return null;
			}
		} catch (IOException WJDDpea5) {
			if (DgjXEAqP.isConnected()) {
				try {
					DgjXEAqP.disconnect();
				} catch (IOException mZwokvGr) {
					return null;
				}
			}
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP Could not connect to server.");
			ResourcePool.LogException(WJDDpea5, this);
			return null;
		}
		try {
			if (!DgjXEAqP.login(pfvjBzw5, sHqGKOZ2)) {
				DgjXEAqP.logout();
				ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP login failed.");
				return null;
			}
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE,
					"Remote system is " + DgjXEAqP.getSystemName() + ", " + uWUvulV2);
			if (JgVik6WK) {
				DgjXEAqP.setFileType(FTP.BINARY_FILE_TYPE);
			} else {
				DgjXEAqP.setFileType(FTP.ASCII_FILE_TYPE);
			}
			DgjXEAqP.enterLocalPassiveMode();
		} catch (FTPConnectionClosedException Ckozl812) {
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "Server closed connection.");
			ResourcePool.LogException(Ckozl812, this);
			return null;
		} catch (IOException DXYXWubY) {
			ResourcePool.LogException(DXYXWubY, this);
			return null;
		}
		return DgjXEAqP;
	}

}