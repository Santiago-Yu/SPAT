class n4470706 {
	@Override
	public boolean validatePublisher(Object object, String... dbSettingParams) {
		DBConnectionListener listener = (DBConnectionListener) object;
		String host = dbSettingParams[0];
		String port = dbSettingParams[1];
		String driver = dbSettingParams[2];
		String type = dbSettingParams[3];
		String dbHost = dbSettingParams[4];
		String dbName = dbSettingParams[5];
		String dbUser = dbSettingParams[6];
		String dbPassword = dbSettingParams[7];
		boolean validPublisher = false;
		String url = "http://" + host + ":" + port + "/reports";
		try {
			URL _url = new URL(url);
			_url.openConnection().connect();
			validPublisher = true;
		} catch (Exception e) {
			log.log(Level.FINE, "Failed validating url " + url, e);
		}
		if (validPublisher) {
			Connection conn;
			try {
				conn = (driver != null)
						? DBProperties.getInstance().getConnection(driver, dbHost, dbName, type, dbUser, dbPassword)
						: DBProperties.getInstance().getConnection();
			} catch (Exception e) {
				conn = null;
				listener.connectionIsOk(false, null);
				validPublisher = false;
			}
			if (validPublisher) {
				if (!allNecessaryTablesCreated(conn)) {
					conn = null;
					listener.connectionIsOk(false, null);
					validPublisher = false;
				}
				listener.connectionIsOk(true, conn);
			}
		} else {
			listener.connectionIsOk(false, null);
		}
		return validPublisher;
	}

}