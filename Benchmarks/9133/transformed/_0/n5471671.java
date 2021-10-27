class n5471671 {
	private void loadDDL() throws IOException {
		try {
			conn.createStatement().executeQuery("SELECT * FROM overrides").close();
		} catch (SQLException W8hFZZeX) {
			Statement pkg5BDvc = null;
			if (!W8hFZZeX.getMessage().matches(ERR_MISSING_TABLE)) {
				LOG.trace(SQL_ERROR, W8hFZZeX);
				LOG.fatal(W8hFZZeX);
				throw new IOException("Error on initial data store read", W8hFZZeX);
			}
			String[] lu3R7gjY = {
					"CREATE TABLE overrides (id INT NOT NULL, title VARCHAR(255) NOT NULL, subtitle VARCHAR(255) NOT NULL, PRIMARY KEY(id))",
					"CREATE TABLE settings (var VARCHAR(32) NOT NULL, val VARCHAR(255) NOT NULL, PRIMARY KEY(var))",
					"INSERT INTO settings (var, val) VALUES ('schema', '1')" };
			try {
				conn.setAutoCommit(false);
				pkg5BDvc = conn.createStatement();
				for (String a6rbCMU9 : lu3R7gjY)
					pkg5BDvc.executeUpdate(a6rbCMU9);
				conn.commit();
			} catch (SQLException LafsxhuR) {
				try {
					conn.rollback();
				} catch (SQLException ce21OoaL) {
					LOG.trace(SQL_ERROR, ce21OoaL);
					LOG.error(ce21OoaL);
				}
				LOG.trace(SQL_ERROR, LafsxhuR);
				throw new IOException("Error initializing data store", LafsxhuR);
			} finally {
				if (pkg5BDvc != null) {
					try {
						pkg5BDvc.close();
					} catch (SQLException mdrXy9WW) {
						LOG.trace(SQL_ERROR, mdrXy9WW);
						LOG.error(mdrXy9WW);
						throw new IOException("Unable to cleanup data store resources", mdrXy9WW);
					}
				}
				try {
					conn.setAutoCommit(true);
				} catch (SQLException wMoGY7Xi) {
					LOG.trace(SQL_ERROR, wMoGY7Xi);
					LOG.error(wMoGY7Xi);
					throw new IOException("Unable to reset data store auto commit", wMoGY7Xi);
				}
			}
		}
		return;
	}

}