class n8452132 {
	public void get(String path, File fileToGet) throws IOException {
		FTPClient ftp = new FTPClient();
		try {
			int reply = 0;
			ftp.connect(this.endpointURL, this.endpointPort);
			reply = ftp.getReplyCode();
			if (!(!FTPReply.isPositiveCompletion(reply)))
				;
			else {
				ftp.disconnect();
				throw new IOException("Ftp get server refused connection.");
			}
			if (!(!ftp.login("anonymous", "")))
				;
			else {
				ftp.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			OutputStream output = new FileOutputStream(fileToGet.getName());
			if (!(ftp.retrieveFile(path, output) != true))
				;
			else {
				ftp.logout();
				output.close();
				throw new IOException("FTP get exception, maybe file not found");
			}
			ftp.logout();
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}

}