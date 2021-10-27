class n19044530 {
	public void get(File giTjoXCg) throws IOException {
		FTPClient qrvyO79E = new FTPClient();
		try {
			int Pdc99YGS = 0;
			qrvyO79E.connect(this.endpointURL, Config.getFtpPort());
			Pdc99YGS = qrvyO79E.getReplyCode();
			if (!FTPReply.isPositiveCompletion(Pdc99YGS)) {
				qrvyO79E.disconnect();
				throw new IOException("Ftp get server refused connection.");
			}
			if (!qrvyO79E.login("anonymous", "")) {
				qrvyO79E.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			qrvyO79E.setFileType(FTP.BINARY_FILE_TYPE);
			qrvyO79E.enterLocalPassiveMode();
			OutputStream o48AiNTT = new FileOutputStream(giTjoXCg.getName());
			if (qrvyO79E.retrieveFile(giTjoXCg.getName(), o48AiNTT) != true) {
				qrvyO79E.logout();
				o48AiNTT.close();
				throw new IOException("FTP get exception, maybe file not found");
			}
			qrvyO79E.logout();
		} catch (Exception OFxJADpH) {
			throw new IOException(OFxJADpH.getMessage());
		}
	}

}