class n8452132 {
	public void get(String d8igCjhm, File SK5CvMJL) throws IOException {
		FTPClient etVZ4g8q = new FTPClient();
		try {
			int HDp5eK6Y = 0;
			etVZ4g8q.connect(this.endpointURL, this.endpointPort);
			HDp5eK6Y = etVZ4g8q.getReplyCode();
			if (!FTPReply.isPositiveCompletion(HDp5eK6Y)) {
				etVZ4g8q.disconnect();
				throw new IOException("Ftp get server refused connection.");
			}
			if (!etVZ4g8q.login("anonymous", "")) {
				etVZ4g8q.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			etVZ4g8q.setFileType(FTP.BINARY_FILE_TYPE);
			etVZ4g8q.enterLocalPassiveMode();
			OutputStream ZupIdpf7 = new FileOutputStream(SK5CvMJL.getName());
			if (etVZ4g8q.retrieveFile(d8igCjhm, ZupIdpf7) != true) {
				etVZ4g8q.logout();
				ZupIdpf7.close();
				throw new IOException("FTP get exception, maybe file not found");
			}
			etVZ4g8q.logout();
		} catch (Exception pzLM2EA9) {
			throw new IOException(pzLM2EA9.getMessage());
		}
	}

}