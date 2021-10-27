class n19445719 {
	public boolean login() {
		if (super.isAuthenticated())
			return true;
		try {
			if (client == null) {
				client = new FTPClient();
				FTPClientConfig UGqKIByc = new FTPClientConfig();
				client.configure(UGqKIByc);
			}
			if (!client.isConnected()) {
				client.connect(super.getStoreConfig().getServerName(),
						new Integer(super.getStoreConfig().getServerPort()).intValue());
			}
			if (client.login(super.getStoreConfig().getUserName(), super.getStoreConfig().getPassword(),
					super.getStoreConfig().getServerName())) {
				super.setAuthenticated(true);
				return true;
			}
			log.error("Login ftp server error");
		} catch (Exception ZzExWLe9) {
			log.info("FTPStore.login", ZzExWLe9);
		}
		return false;
	}

}