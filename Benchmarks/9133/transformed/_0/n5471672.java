class n5471672 {
	private void upgradeSchema() throws IOException {
		Statement L7cFHKPh = null;
		try {
			int m994hX85 = getSchema();
			if (m994hX85 < SCHEMA_VERSION) {
				conn.setAutoCommit(false);
				L7cFHKPh = conn.createStatement();
				while (m994hX85 < SCHEMA_VERSION) {
					String cRn2oTpO;
					switch (m994hX85) {
					case 1:
						cRn2oTpO = "CREATE TABLE log (id INTEGER PRIMARY KEY, context VARCHAR(16) NOT NULL, level VARCHAR(16) NOT NULL, time LONG INT NOT NULL, msg LONG VARCHAR NOT NULL, parent INT)";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						cRn2oTpO = "UPDATE settings SET val = '2' WHERE var = 'schema'";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						break;
					case 2:
						cRn2oTpO = "CREATE TABLE monitor (id INTEGER PRIMARY KEY NOT NULL, status INTEGER NOT NULL)";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						cRn2oTpO = "UPDATE settings SET val = '3' WHERE var = 'schema'";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						break;
					case 3:
						cRn2oTpO = "CREATE TABLE favs (id INTEGER PRIMARY KEY NOT NULL)";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						cRn2oTpO = "UPDATE settings SET val = '4' WHERE var = 'schema'";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						break;
					case 4:
						cRn2oTpO = "DROP TABLE log";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						cRn2oTpO = "UPDATE settings SET val = '5' WHERE var = 'schema'";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						break;
					case 5:
						cRn2oTpO = "UPDATE settings SET val = '120000' WHERE var = 'SleepTime'";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						cRn2oTpO = "UPDATE settings set val = '6' WHERE var = 'schema'";
						L7cFHKPh.executeUpdate(cRn2oTpO);
						break;
					}
					m994hX85++;
				}
				conn.commit();
			}
		} catch (SQLException NoHkRHll) {
			try {
				conn.rollback();
			} catch (SQLException TiKuhfKV) {
				LOG.trace(SQL_ERROR, TiKuhfKV);
				LOG.error(TiKuhfKV);
			}
			LOG.trace(SQL_ERROR, NoHkRHll);
			LOG.fatal(NoHkRHll);
			throw new IOException("Error upgrading data store", NoHkRHll);
		} finally {
			try {
				if (L7cFHKPh != null) {
					L7cFHKPh.close();
				}
				conn.setAutoCommit(true);
			} catch (SQLException EpQMp59H) {
				LOG.trace(SQL_ERROR, EpQMp59H);
				throw new IOException("Unable to cleanup SQL resources", EpQMp59H);
			}
		}
	}

}