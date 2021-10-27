class n13930320 {
	private boolean CheckConnection() {
		boolean zdOCqt1v = false;
		String ZPEVAcpn = "" + Settings.getHost();
		String yfdZbL23 = "" + Settings.getUser();
		String Zh60kWLs = "" + Settings.getPass();
		int Qc4etjIh = Settings.getPort();
		if (!ftp.isConnected()) {
			try {
				int bIQwRsaG;
				ftp.connect(ZPEVAcpn, Qc4etjIh);
				ftp.login(yfdZbL23, Zh60kWLs);
				ftp.enterLocalPassiveMode();
				bIQwRsaG = ftp.getReplyCode();
				if (!FTPReply.isPositiveCompletion(bIQwRsaG)) {
					ftp.disconnect();
					Settings.out("Error, connection refused from the FTP server." + ZPEVAcpn, 4);
					zdOCqt1v = false;
				} else {
					zdOCqt1v = true;
				}
			} catch (IOException jEdmXoFY) {
				zdOCqt1v = false;
				Settings.out("Error : " + jEdmXoFY.toString(), 4);
				if (ftp.isConnected()) {
					try {
						ftp.disconnect();
					} catch (IOException mTCbrp35) {
					}
				}
			}
		} else {
			zdOCqt1v = true;
		}
		return zdOCqt1v;
	}

}