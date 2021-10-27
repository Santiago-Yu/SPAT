class n8452134 {
	public int exists(String XDUjyIcL) throws IOException {
		FTPClient T0g7HASH = new FTPClient();
		int eu1TXKOJ = 0;
		try {
			int sDV0tzig = 0;
			T0g7HASH.connect(this.endpointURL, this.endpointPort);
			sDV0tzig = T0g7HASH.getReplyCode();
			if (!FTPReply.isPositiveCompletion(sDV0tzig)) {
				T0g7HASH.disconnect();
				throw new IOException("Ftp exists server refused connection.");
			}
			if (!T0g7HASH.login("anonymous", "")) {
				T0g7HASH.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			T0g7HASH.enterLocalPassiveMode();
			if (T0g7HASH.listNames(XDUjyIcL) != null) {
				eu1TXKOJ = 1;
			}
			T0g7HASH.logout();
		} catch (Exception Y4Oe8ggn) {
			throw new IOException(Y4Oe8ggn.getMessage());
		}
		return eu1TXKOJ;
	}

}