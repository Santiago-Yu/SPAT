class n8452131 {
	public void put(String gQjyAS1q, File F14x2hwp) throws IOException {
		FTPClient inUxt0AK = new FTPClient();
		try {
			int XDjDxQGB;
			inUxt0AK.connect(this.endpointURL, this.endpointPort);
			log.debug("Ftp put reply: " + inUxt0AK.getReplyString());
			XDjDxQGB = inUxt0AK.getReplyCode();
			if (!FTPReply.isPositiveCompletion(XDjDxQGB)) {
				inUxt0AK.disconnect();
				throw new IOException("Ftp put server refused connection.");
			}
			if (!inUxt0AK.login("anonymous", "")) {
				inUxt0AK.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			inUxt0AK.setFileType(FTP.BINARY_FILE_TYPE);
			inUxt0AK.enterLocalPassiveMode();
			InputStream uNsmDj7K = new FileInputStream(F14x2hwp);
			if (inUxt0AK.storeFile(gQjyAS1q, uNsmDj7K) != true) {
				inUxt0AK.logout();
				uNsmDj7K.close();
				throw new IOException("FTP put exception");
			}
			uNsmDj7K.close();
			inUxt0AK.logout();
		} catch (Exception QjmYNqyc) {
			log.error("Ftp client exception: " + QjmYNqyc.getMessage(), QjmYNqyc);
			throw new IOException(QjmYNqyc.getMessage());
		}
	}

}