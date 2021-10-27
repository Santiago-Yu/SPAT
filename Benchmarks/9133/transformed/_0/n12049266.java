class n12049266 {
	private FTPClient getFTPConnection(String WFJylaUp, String xdapaKqT, String yHIIEMRO, boolean VtwBj4AV,
			String QWVM90zC, boolean avyckVAv) {
		FTPClient HlorWEzk = new FTPClient();
		try {
			int XTEXFSKL;
			HlorWEzk.connect(yHIIEMRO);
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE, "Connected to " + yHIIEMRO + ", " + QWVM90zC);
			XTEXFSKL = HlorWEzk.getReplyCode();
			if (!FTPReply.isPositiveCompletion(XTEXFSKL)) {
				HlorWEzk.disconnect();
				ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP server refused connection.");
				return null;
			}
		} catch (IOException QmUl0Tgj) {
			if (HlorWEzk.isConnected()) {
				try {
					HlorWEzk.disconnect();
				} catch (IOException ohNknwFj) {
					return null;
				}
			}
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP Could not connect to server.");
			ResourcePool.LogException(QmUl0Tgj, this);
			return null;
		}
		try {
			if (!HlorWEzk.login(WFJylaUp, xdapaKqT)) {
				HlorWEzk.logout();
				ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP login failed.");
				return null;
			}
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE,
					"Remote system is " + HlorWEzk.getSystemName() + ", " + QWVM90zC);
			if (VtwBj4AV) {
				HlorWEzk.setFileType(FTP.BINARY_FILE_TYPE);
			} else {
				HlorWEzk.setFileType(FTP.ASCII_FILE_TYPE);
			}
			if (avyckVAv) {
				HlorWEzk.enterLocalPassiveMode();
			} else {
				HlorWEzk.enterLocalActiveMode();
			}
		} catch (FTPConnectionClosedException Dn27k677) {
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "Server closed connection.");
			ResourcePool.LogException(Dn27k677, this);
			return null;
		} catch (IOException HB3YAdYj) {
			ResourcePool.LogException(HB3YAdYj, this);
			return null;
		}
		return HlorWEzk;
	}

}