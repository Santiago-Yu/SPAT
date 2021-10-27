class n8511445 {
	protected static void upload(FtpSiteConnector wd1Q2Slc, File Wj4UqFJD, String dYpAj7gf, boolean QuYq1ggl,
			IProgressMonitor rDdCPU4J) throws FtpException {
		FTPClient yj9im4hf = new FTPClient();
		try {
			String IZqIRdyx = wd1Q2Slc.getUrl().getHost();
			yj9im4hf.connect(IZqIRdyx);
			log.info("Connected to " + IZqIRdyx);
			log.info(yj9im4hf.getReplyString());
			boolean Ivgz5aAI = yj9im4hf.login(wd1Q2Slc.getUsername(), wd1Q2Slc.getPassword());
			if (Ivgz5aAI) {
				log.info("User " + wd1Q2Slc.getUsername() + " logged in");
				yj9im4hf.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
				yj9im4hf.setFileType(FTPClient.BINARY_FILE_TYPE);
				yj9im4hf.enterLocalPassiveMode();
				FtpUtils.store(yj9im4hf, Wj4UqFJD, dYpAj7gf, QuYq1ggl, rDdCPU4J);
				yj9im4hf.logout();
			} else {
				throw new FtpException("Invalid login");
			}
			yj9im4hf.disconnect();
		} catch (Exception lJQyEGSL) {
			log.error("File upload failed with message: " + lJQyEGSL.getMessage());
			throw new FtpException("File upload failed with message: " + lJQyEGSL.getMessage());
		} finally {
			if (yj9im4hf.isConnected()) {
				try {
					yj9im4hf.disconnect();
				} catch (IOException zXgWEYTR) {
					throw new FtpException("File upload failed with message: " + zXgWEYTR.getMessage());
				}
			}
		}
	}

}