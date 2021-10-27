class n4792385 {
	private void upgradeSchema() {
		Statement askLYH5s = null;
		boolean QSt0771x = false;
		try {
			int Td0vWk0o = getSchema();
			if (Td0vWk0o < SCHEMA_VERSION) {
				conn.setAutoCommit(false);
				askLYH5s = conn.createStatement();
				QSt0771x = true;
			}
			while (Td0vWk0o < SCHEMA_VERSION) {
				String Qu4cqXIw;
				switch (Td0vWk0o) {
				case 0:
					Qu4cqXIw = "CREATE TABLE settings (var VARCHAR(32) NOT NULL, val LONG VARCHAR)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "INSERT INTO settings (var, val) VALUES ('schema', '1')";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "ALTER TABLE recordings ADD COLUMN exe LONG VARCHAR NOT NULL DEFAULT '%UNKNOWN%'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE TABLE files (id INT NOT NULL, file LONG VARCHAR NOT NULL, finished INT NOT NULL)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					updateFilesTable();
					break;
				case 1:
					Qu4cqXIw = "ALTER TABLE files ADD COLUMN type VARCHAR(32) NOT NULL DEFAULT '%UNKNOWN%'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '2' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 2:
					Qu4cqXIw = "CREATE UNIQUE INDEX IF NOT EXISTS recordings_history ON recordings(id,type)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE INDEX IF NOT EXISTS files_history ON files(id,type)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '3' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 3:
					Qu4cqXIw = "CREATE TABLE log (id INTEGER PRIMARY KEY, context VARCHAR(16) NOT NULL, level VARCHAR(16) NOT NULL, time LONG INT NOT NULL, msg LONG VARCHAR NOT NULL, parent INT)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '4' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 4:
					Qu4cqXIw = "CREATE UNIQUE INDEX IF NOT EXISTS log_id ON log(id)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE INDEX IF NOT EXISTS log_parent ON log(parent)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '5' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 5:
					Qu4cqXIw = "CREATE TABLE tmp_settings (var varchar(32) NOT NULL PRIMARY KEY, val varchar(128) NOT NULL)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "INSERT INTO tmp_settings SELECT var,val FROM settings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP TABLE settings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "ALTER TABLE tmp_settings RENAME TO settings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '6' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 6:
					Qu4cqXIw = "DROP TABLE log";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE TABLE log (id INTEGER PRIMARY KEY, mediaid varchar(32) NOT NULL, taskid varchar(32) NOT NULL, msg LONG VARCHAR NOT NULL)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '7' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 7:
					Qu4cqXIw = "CREATE TABLE client (host varchar(255) PRIMARY KEY, conf LONG VARCHAR)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '8' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 8:
					Qu4cqXIw = "DROP INDEX files_history";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP INDEX recordings_history";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP TABLE files";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE TABLE new_rec (id INT NOT NULL, type VARCHAR(32) NOT NULL, start INT NOT NULL DEFAULT 0, finish INT NOT NULL DEFAULT 0, state INT NOT NULL DEFAULT 1, PRIMARY KEY(id, type))";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "INSERT INTO new_rec SELECT id, type, 0, 0, 1 FROM recordings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP TABLE recordings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE TABLE recordings (id INT NOT NULL, type VARCHAR(32) NOT NULL, start INT NOT NULL DEFAULT 0, finish INT NOT NULL DEFAULT 0, state INT NOT NULL DEFAULT 1, PRIMARY KEY(id, type))";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "INSERT INTO recordings SELECT * FROM new_rec";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP TABLE new_rec";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE UNIQUE INDEX recordings_history on recordings(id,type)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '9' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 9:
					Qu4cqXIw = "ALTER TABLE recordings ADD COLUMN host VARCHAR(255) NOT NULL DEFAULT ''";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '10' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 10:
					Qu4cqXIw = "ALTER TABLE recordings ADD COLUMN airing VARCHAR(64) NOT NULL DEFAULT '0'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '11' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 11:
					PreparedStatement Hjhpctqn = null;
					try {
						MessageDigest bn1NiW4B = MessageDigest.getInstance("MD5");
						bn1NiW4B.update("sjqadmin".getBytes());
						String VeKisj8B = new String(bn1NiW4B.digest());
						Hjhpctqn = conn.prepareStatement("REPLACE INTO settings (var, val) VALUES ('password', ?)");
						Hjhpctqn.setString(1, VeKisj8B);
						Hjhpctqn.executeUpdate();
					} catch (NoSuchAlgorithmException pHmFt97T) {
						throw new SQLException(pHmFt97T);
					} finally {
						if (Hjhpctqn != null)
							Hjhpctqn.close();
					}
					askLYH5s.executeUpdate("UPDATE settings SET val = '12' WHERE var = 'schema'");
					break;
				case 12:
					Qu4cqXIw = "CREATE INDEX logs_for_tasks ON log(mediaid, taskid)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '13' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 13:
					Qu4cqXIw = "DELETE FROM log";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '14' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 14:
					Qu4cqXIw = "DROP TABLE log";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE TABLE log (id INTEGER PRIMARY KEY, mediaid varchar(32) NOT NULL, taskid varchar(32) NOT NULL, msg LONG VARCHAR NOT NULL, ts INTEGER NOT NULL DEFAULT 0)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE INDEX logs_by_date ON log(ts)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE INDEX IF NOT EXISTS logs_for_tasks ON log(mediaid, taskid)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '15' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 15:
					Qu4cqXIw = "DELETE FROM log WHERE mediaid = 0 AND taskid = '0'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '16' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 16:
					Qu4cqXIw = "CREATE TEMPORARY TABLE rec_tmp (objtype varchar(64) NOT NULL DEFAULT 'media', id INT NOT NULL, type VARCHAR(32) NOT NULL, start INT NOT NULL DEFAULT 0, finish INT NOT NULL DEFAULT 0, state INT NOT NULL DEFAULT 1, host VARCHAR(255) NOT NULL DEFAULT '', airing VARCHAR(64) NOT NULL DEFAULT '0', PRIMARY KEY (objtype, id, type))";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "INSERT INTO rec_tmp SELECT 'media', id, type, start, finish, state, host, airing FROM recordings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP TABLE recordings";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE TABLE recordings (objtype varchar(64) NOT NULL DEFAULT 'media', id INT NOT NULL, type VARCHAR(32) NOT NULL, start INT NOT NULL DEFAULT 0, finish INT NOT NULL DEFAULT 0, state INT NOT NULL DEFAULT 1, host VARCHAR(255) NOT NULL DEFAULT '', airing VARCHAR(64) NOT NULL DEFAULT '0', PRIMARY KEY (objtype, id, type))";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "INSERT INTO recordings SELECT * FROM rec_tmp";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "DROP TABLE rec_tmp";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "ALTER TABLE log ADD COLUMN objtype varchar(64) NOT NULL DEFAULT 'media'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '17' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				case 17:
					Qu4cqXIw = "DROP INDEX logs_for_tasks";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "CREATE INDEX logs_for_tasks ON log(mediaid, taskid, objtype)";
					askLYH5s.executeUpdate(Qu4cqXIw);
					Qu4cqXIw = "UPDATE settings SET val = '18' WHERE var = 'schema'";
					askLYH5s.executeUpdate(Qu4cqXIw);
					break;
				}
				Td0vWk0o++;
			}
			if (QSt0771x)
				conn.commit();
		} catch (SQLException ftWmNWLv) {
			try {
				if (QSt0771x)
					conn.rollback();
			} catch (SQLException s79KFtm6) {
				LOG.fatal("SQL error", s79KFtm6);
			}
			LOG.fatal("SQL error", ftWmNWLv);
			throw new RuntimeException(ftWmNWLv);
		} finally {
			try {
				if (askLYH5s != null)
					askLYH5s.close();
				if (QSt0771x)
					conn.setAutoCommit(true);
			} catch (SQLException kvkvPCN3) {
				LOG.fatal("SQL error", kvkvPCN3);
				throw new RuntimeException(kvkvPCN3);
			}
		}
	}

}