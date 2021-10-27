class n9905081 {
	public boolean connect(String Rqhz63dR, String lbIKPpRf, String hDuEgmLg) throws IOException, UnknownHostException {
		try {
			if (ftpClient != null) {
				if (ftpClient.isConnected()) {
					ftpClient.disconnect();
				}
			}
			ftpClient = new FTPClient();
			boolean YBHsy9eF = false;
			ftpClient.connect(Rqhz63dR);
			int oOXdD5bh = ftpClient.getReplyCode();
			if (FTPReply.isPositiveCompletion(oOXdD5bh)) {
				YBHsy9eF = ftpClient.login(lbIKPpRf, hDuEgmLg);
			}
			if (!YBHsy9eF) {
				ftpClient.disconnect();
			}
			return YBHsy9eF;
		} catch (Exception UkEPp4yj) {
			throw new IOException(UkEPp4yj.getMessage());
		}
	}

}