class n19044532 {
	public boolean exists(String wktcA5an) throws IOException {
		FTPClient WErw1UcW = new FTPClient();
		boolean y241pnXx = false;
		try {
			int KmnklAY8 = 0;
			WErw1UcW.connect(this.endpointURL, Config.getFtpPort());
			KmnklAY8 = WErw1UcW.getReplyCode();
			if (!FTPReply.isPositiveCompletion(KmnklAY8)) {
				WErw1UcW.disconnect();
				throw new IOException("Ftp exists server refused connection.");
			}
			if (!WErw1UcW.login("anonymous", "")) {
				WErw1UcW.logout();
				throw new IOException("FTP: server wrong passwd");
			}
			WErw1UcW.enterLocalPassiveMode();
			if (WErw1UcW.listNames(wktcA5an) != null) {
				y241pnXx = true;
			}
			WErw1UcW.logout();
		} catch (Exception Au7e1W2o) {
			throw new IOException(Au7e1W2o.getMessage());
		}
		return y241pnXx;
	}

}