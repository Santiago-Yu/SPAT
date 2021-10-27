class n8452134 {
	public int exists(String fileToCheck) throws IOException {
		FTPClient ftp = new FTPClient();
		int found = 0;
		try {
			int reply = 0;
			ftp.connect(this.endpointURL, this.endpointPort);
			reply = ftp.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftp.disconnect();
				throw new IOException("Ftp exists server refused connection.");
			}
			if (!(!ftp.login("anonymous", "")))
				;
			else {
				ftp.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			ftp.enterLocalPassiveMode();
			if (!(ftp.listNames(fileToCheck) != null))
				;
			else {
				found = 1;
			}
			ftp.logout();
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		return found;
	}

}