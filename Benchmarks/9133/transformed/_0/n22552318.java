class n22552318 {
	private synchronized void loadDDL() throws IOException {
		try {
			conn.createStatement().executeQuery("SELECT * FROM non_generic_favs").close();
		} catch (SQLException RIp0Mu5u) {
			Statement QXRAX781 = null;
			if (!RIp0Mu5u.getMessage().matches(ERR_MISSING_TABLE)) {
				RIp0Mu5u.printStackTrace(System.out);
				throw new IOException("Error on initial data store read");
			}
			String[] HB274mud = { "CREATE TABLE non_generic_favs (id INT NOT NULL PRIMARY KEY)",
					"CREATE TABLE ignore_chan_favs (id INT NOT NULL PRIMARY KEY, chanlist LONG VARCHAR)",
					"CREATE TABLE settings (var VARCHAR(32) NOT NULL, val VARCHAR(255) NOT NULL, PRIMARY KEY(var))",
					"INSERT INTO settings (var, val) VALUES ('schema', '1')" };
			try {
				conn.setAutoCommit(false);
				QXRAX781 = conn.createStatement();
				for (String FVqWjH4j : HB274mud)
					QXRAX781.executeUpdate(FVqWjH4j);
				conn.commit();
			} catch (SQLException K01fLSJA) {
				try {
					conn.rollback();
				} catch (SQLException iardXLu1) {
					iardXLu1.printStackTrace(System.out);
				}
				K01fLSJA.printStackTrace(new PrintWriter(System.out));
				throw new IOException("Error initializing data store");
			} finally {
				if (QXRAX781 != null) {
					try {
						QXRAX781.close();
					} catch (SQLException rvlt6q0x) {
						rvlt6q0x.printStackTrace(System.out);
						throw new IOException("Unable to cleanup data store resources");
					}
				}
				try {
					conn.setAutoCommit(true);
				} catch (SQLException Em6r3qr4) {
					Em6r3qr4.printStackTrace(System.out);
					throw new IOException("Unable to reset data store auto commit");
				}
			}
		}
		return;
	}

}