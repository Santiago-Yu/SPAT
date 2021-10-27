class n12393199 {
	public int getDBVersion() throws MigrationException {
		PreparedStatement ps;
		int dbVersion;
		try {
			Connection conn = getConnection();
			ps = conn.prepareStatement("SELECT version FROM " + getTablename());
			try {
				ResultSet rs = ps.executeQuery();
				try {
					if (rs.next()) {
						dbVersion = rs.getInt(1);
						if (rs.next()) {
							throw new MigrationException("Too many version in table: " + getTablename());
						}
					} else {
						ps.close();
						ps = conn.prepareStatement("INSERT INTO " + getTablename() + " (version) VALUES (?)");
						ps.setInt(1, 1);
						dbVersion = 1;
						try {
							ps.executeUpdate();
						} finally {
							ps.close();
						}
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Could not access " + tablename + ": " + e);
			Connection conn = getConnection();
			dbVersion = 0;
			try {
				if (!conn.getAutoCommit()) {
					conn.rollback();
				}
				conn.setAutoCommit(false);
			} catch (SQLException e1) {
				throw new MigrationException("Could not reset transaction state", e1);
			}
		}
		return dbVersion;
	}

}