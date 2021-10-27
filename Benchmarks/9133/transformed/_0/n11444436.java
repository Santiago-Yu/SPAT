class n11444436 {
	public void run() {
		try {
			FTPClient fXjsD1XG = new FTPClient();
			fXjsD1XG.configure(ftpConfig);
			logger.debug("Trying to connect");
			fXjsD1XG.connect("127.0.0.1", 21211);
			logger.debug("Connected");
			fXjsD1XG.setSoTimeout(5000);
			if (!FTPReply.isPositiveCompletion(fXjsD1XG.getReplyCode())) {
				logger.debug("Houston, we have a problem. D/C");
				fXjsD1XG.disconnect();
				throw new Exception();
			}
			if (fXjsD1XG.login("drftpd", "drftpd")) {
				logger.debug("Logged-in, now waiting 5 secs and kill the thread.");
				_sc.addSuccess();
				Thread.sleep(5000);
				fXjsD1XG.disconnect();
			} else {
				logger.debug("Login failed, D/C!");
				throw new Exception();
			}
		} catch (Exception NS9Aog2D) {
			logger.debug(NS9Aog2D, NS9Aog2D);
			_sc.addFailure();
		}
		logger.debug("exiting");
	}

}