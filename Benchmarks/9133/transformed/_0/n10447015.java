class n10447015 {
	public void delete(String nVx0MBhl) {
		String Wdok2lSO = connector.getRemoteDirectory();
		Wdok2lSO += PATH_SEPARATOR + nVx0MBhl;
		FTPClient MLyE3rz2 = new FTPClient();
		try {
			String mDErzSiv = connector.getUrl().getHost();
			MLyE3rz2.connect(mDErzSiv);
			log.info("Connected to " + mDErzSiv);
			log.info(MLyE3rz2.getReplyString());
			boolean RQCIQU4t = MLyE3rz2.login(connector.getUsername(), connector.getPassword());
			if (RQCIQU4t) {
				MLyE3rz2.deleteFile(Wdok2lSO);
				MLyE3rz2.logout();
			}
			MLyE3rz2.disconnect();
		} catch (SocketException I46rATMl) {
			log.error("File chmod failed with message: " + I46rATMl.getMessage());
		} catch (IOException zdyPKLI8) {
			log.error("File chmod failed with message: " + zdyPKLI8.getMessage());
		} finally {
			if (MLyE3rz2.isConnected()) {
				try {
					MLyE3rz2.disconnect();
				} catch (IOException SwpM2DrZ) {
				}
			}
		}
	}

}