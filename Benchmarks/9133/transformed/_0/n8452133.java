class n8452133 {
	public void delete(String SsNxhcBF) throws IOException {
		FTPClient h2ZCwl7j = new FTPClient();
		try {
			int r73hFokl = 0;
			h2ZCwl7j.connect(this.endpointURL, this.endpointPort);
			r73hFokl = h2ZCwl7j.getReplyCode();
			if (!FTPReply.isPositiveCompletion(r73hFokl)) {
				h2ZCwl7j.disconnect();
				throw new IOException("Ftp delete server refused connection.");
			}
			if (!h2ZCwl7j.login("anonymous", "")) {
				h2ZCwl7j.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			h2ZCwl7j.enterLocalPassiveMode();
			log.debug("Deleted: " + h2ZCwl7j.deleteFile(SsNxhcBF));
			h2ZCwl7j.logout();
		} catch (Exception aarNNADY) {
			throw new IOException(aarNNADY.getMessage());
		}
	}

}