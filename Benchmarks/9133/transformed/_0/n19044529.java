class n19044529 {
	public void put(File usPLp4iJ) throws IOException {
		FTPClient xT3H04Lb = new FTPClient();
		try {
			int UEyKfPUW;
			xT3H04Lb.connect(this.endpointURL, Config.getFtpPort());
			log.debug("Ftp put reply: " + xT3H04Lb.getReplyString());
			UEyKfPUW = xT3H04Lb.getReplyCode();
			if (!FTPReply.isPositiveCompletion(UEyKfPUW)) {
				xT3H04Lb.disconnect();
				throw new IOException("Ftp put server refused connection.");
			}
			if (!xT3H04Lb.login("anonymous", "")) {
				xT3H04Lb.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			xT3H04Lb.setFileType(FTP.BINARY_FILE_TYPE);
			xT3H04Lb.enterLocalPassiveMode();
			InputStream wYYtcEpd = new FileInputStream(usPLp4iJ);
			if (xT3H04Lb.storeFile(usPLp4iJ.getName(), wYYtcEpd) != true) {
				xT3H04Lb.logout();
				wYYtcEpd.close();
				throw new IOException("FTP put exception");
			}
			wYYtcEpd.close();
			xT3H04Lb.logout();
		} catch (Exception sXLNttMY) {
			log.error("Ftp client exception: " + sXLNttMY.getMessage(), sXLNttMY);
			throw new IOException(sXLNttMY.getMessage());
		}
	}

}