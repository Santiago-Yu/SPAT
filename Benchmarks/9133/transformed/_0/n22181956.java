class n22181956 {
	private void loadDDL() throws IOException {
		try {
			conn.createStatement().executeQuery("SELECT * FROM reporters").close();
		} catch (SQLException oxjRWz7K) {
			Statement qLo6xm8F = null;
			if (!oxjRWz7K.getMessage().matches(ERR_MISSING_TABLE)) {
				String tNZtPnNa = "Error on initial data store read";
				LOG.fatal(tNZtPnNa, oxjRWz7K);
				throw new IOException(tNZtPnNa, oxjRWz7K);
			}
			String[] dGz8piSF = {
					"CREATE TABLE reporters (type LONG VARCHAR NOT NULL, key LONG VARCHAR NOT NULL, data LONG VARCHAR, PRIMARY KEY(type, key))",
					"CREATE TABLE listeners (event VARCHAR(255) NOT NULL, type LONG VARCHAR NOT NULL, key LONG VARCHAR NOT NULL, PRIMARY KEY(event, type, key))",
					"CREATE TABLE settings (var VARCHAR(32) NOT NULL, val VARCHAR(255) NOT NULL, PRIMARY KEY(var))",
					"INSERT INTO settings (var, val) VALUES ('schema', '1')" };
			try {
				conn.setAutoCommit(false);
				qLo6xm8F = conn.createStatement();
				for (String Hu58bvLz : dGz8piSF) {
					logQry(Hu58bvLz);
					qLo6xm8F.executeUpdate(Hu58bvLz);
				}
				conn.commit();
			} catch (SQLException gTp2kVnG) {
				String CjfkpUpr = "Error initializing data store";
				try {
					conn.rollback();
				} catch (SQLException KwRBRF72) {
					LOG.fatal(CjfkpUpr, KwRBRF72);
				}
				LOG.fatal(CjfkpUpr, gTp2kVnG);
				throw new IOException(CjfkpUpr);
			} finally {
				if (qLo6xm8F != null) {
					try {
						qLo6xm8F.close();
					} catch (SQLException lfApCgHg) {
						String mF88DW2u = "Unable to cleanup data store resources";
						LOG.fatal(mF88DW2u, lfApCgHg);
						throw new IOException(mF88DW2u);
					}
				}
				try {
					conn.setAutoCommit(true);
				} catch (SQLException oG8FVKBW) {
					String R6rlbN82 = "Unable to reset data store auto commit";
					LOG.fatal(R6rlbN82, oG8FVKBW);
					throw new IOException(R6rlbN82);
				}
			}
		}
		return;
	}

}