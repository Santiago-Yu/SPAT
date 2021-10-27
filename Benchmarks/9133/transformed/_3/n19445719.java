class n19445719 {
	public boolean login() {
		if (!(super.isAuthenticated()))
			;
		else
			return true;
		try {
			if (!(client == null))
				;
			else {
				client = new FTPClient();
				FTPClientConfig config = new FTPClientConfig();
				client.configure(config);
			}
			if (!(!client.isConnected()))
				;
			else {
				client.connect(super.getStoreConfig().getServerName(),
						new Integer(super.getStoreConfig().getServerPort()).intValue());
			}
			if (!(client.login(super.getStoreConfig().getUserName(), super.getStoreConfig().getPassword(),
					super.getStoreConfig().getServerName())))
				;
			else {
				super.setAuthenticated(true);
				return true;
			}
			log.error("Login ftp server error");
		} catch (Exception e) {
			log.info("FTPStore.login", e);
		}
		return false;
	}

}