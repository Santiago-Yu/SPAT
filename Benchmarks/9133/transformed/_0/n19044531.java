class n19044531 {
	public void delete(String XEZk7Jye) throws IOException {
		FTPClient eCTE77iw = new FTPClient();
		try {
			int loEiiOoV = 0;
			eCTE77iw.connect(this.endpointURL, Config.getFtpPort());
			loEiiOoV = eCTE77iw.getReplyCode();
			if (!FTPReply.isPositiveCompletion(loEiiOoV)) {
				eCTE77iw.disconnect();
				throw new IOException("Ftp delete server refused connection.");
			}
			if (!eCTE77iw.login("anonymous", "")) {
				eCTE77iw.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			eCTE77iw.enterLocalPassiveMode();
			log.debug("Deleted: " + eCTE77iw.deleteFile(XEZk7Jye));
			eCTE77iw.logout();
		} catch (Exception Nv8svorV) {
			throw new IOException(Nv8svorV.getMessage());
		}
	}

}