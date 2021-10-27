class n5565615 {
	protected FTPClient openFTP() throws CruiseControlException {
		LOG.info("Opening FTP connection to " + targetHost);
		FTPClient nJCRFlh5 = new FTPClient();
		try {
			nJCRFlh5.connect(targetHost, targetPort);
			if (!FTPReply.isPositiveCompletion(nJCRFlh5.getReplyCode())) {
				throw new CruiseControlException("FTP connection failed: " + nJCRFlh5.getReplyString());
			}
			LOG.info("logging in to FTP server");
			if (!nJCRFlh5.login(targetUser, targetPasswd)) {
				throw new CruiseControlException("Could not login to FTP server");
			}
			LOG.info("login succeeded");
			if (passive) {
				setPassive(nJCRFlh5);
			}
		} catch (IOException QEEa3GbN) {
			LOG.error(QEEa3GbN);
			throw new CruiseControlException(QEEa3GbN.getMessage());
		}
		return nJCRFlh5;
	}

}