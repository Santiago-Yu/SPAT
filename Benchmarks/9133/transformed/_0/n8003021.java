class n8003021 {
	@Override
	public void run() {
		URL dENC0duN = null;
		FileOutputStream QRmEtoUC = null;
		FTPClient HCgV00Mo = null;
		try {
			dENC0duN = new URL(super.getAddress());
			String UUi4WlMW = dENC0duN.getHost();
			String tsDIjkzl = StringUtils.substringBeforeLast(dENC0duN.getPath(), "/");
			String jKXGamSH = StringUtils.substringAfterLast(dENC0duN.getPath(), "/");
			HCgV00Mo = new FTPClient(UUi4WlMW, 21);
			if (!HCgV00Mo.connected()) {
				HCgV00Mo.connect();
			}
			HCgV00Mo.login("anonymous", "me@mymail.com");
			logger.info("Connected to " + UUi4WlMW + ".");
			logger.info(HCgV00Mo.getLastValidReply().getReplyText());
			logger.debug("changing dir to " + tsDIjkzl);
			HCgV00Mo.chdir(tsDIjkzl);
			QRmEtoUC = new FileOutputStream(localFileName);
			logger.info("Downloading file " + jKXGamSH + "...");
			HCgV00Mo.setType(FTPTransferType.BINARY);
			HCgV00Mo.get(QRmEtoUC, jKXGamSH);
			logger.info("Done.");
		} catch (Exception X1C1SToc) {
			logger.error(X1C1SToc.getMessage());
			logger.debug(X1C1SToc.getStackTrace());
		} finally {
			try {
				HCgV00Mo.quit();
				QRmEtoUC.close();
			} catch (Exception tVCvOAla) {
			}
		}
	}

}