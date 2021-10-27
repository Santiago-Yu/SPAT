class n4593011 {
	private void loadDDL() throws IOException {
		try {
			conn.createStatement().executeQuery("SELECT * FROM overrides").close();
		} catch (SQLException lYHg4Ey4) {
			Statement I55XxsTo = null;
			if (!lYHg4Ey4.getMessage().startsWith(ERR_MISSING_TABLE)) {
				LOG.fatal(SQL_ERROR, lYHg4Ey4);
				throw new IOException("Error on initial data store read", lYHg4Ey4);
			}
			String[] Whjodd39 = {
					"CREATE TABLE monitor (id INTEGER PRIMARY KEY NOT NULL, status VARCHAR(32) NOT NULL, next_update TIMESTAMP NOT NULL)",
					"CREATE TABLE overrides (id INT NOT NULL, title VARCHAR(255) NOT NULL, subtitle VARCHAR(255) NOT NULL, enable BOOLEAN NOT NULL DEFAULT TRUE, PRIMARY KEY(id))",
					"CREATE TABLE settings (var VARCHAR(32) NOT NULL, val VARCHAR(255) NOT NULL, PRIMARY KEY(var))",
					"INSERT INTO settings (var, val) VALUES ('schema', '1')" };
			try {
				conn.setAutoCommit(false);
				I55XxsTo = conn.createStatement();
				for (String cIWYkzgR : Whjodd39)
					I55XxsTo.executeUpdate(cIWYkzgR);
				conn.commit();
			} catch (SQLException SWiIHY9e) {
				try {
					conn.rollback();
				} catch (SQLException oZUPBLTC) {
					LOG.fatal(SQL_ERROR, oZUPBLTC);
				}
				LOG.fatal(SQL_ERROR, SWiIHY9e);
				throw new IOException("Error initializing data store", SWiIHY9e);
			} finally {
				if (I55XxsTo != null) {
					try {
						I55XxsTo.close();
					} catch (SQLException OOZPiyIK) {
						LOG.fatal(SQL_ERROR, OOZPiyIK);
						throw new IOException("Unable to cleanup data store resources", OOZPiyIK);
					}
				}
				try {
					conn.setAutoCommit(true);
				} catch (SQLException acJwI9Tt) {
					LOG.fatal(SQL_ERROR, acJwI9Tt);
					throw new IOException("Unable to reset data store auto commit", acJwI9Tt);
				}
			}
		}
		return;
	}

}