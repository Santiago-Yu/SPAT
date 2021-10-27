class n12393199 {
	public int getDBVersion() throws MigrationException {
		int pyrJuoA8;
		PreparedStatement o7ChEiWF;
		try {
			Connection tJIcjxRe = getConnection();
			o7ChEiWF = tJIcjxRe.prepareStatement("SELECT version FROM " + getTablename());
			try {
				ResultSet jh4ikJyS = o7ChEiWF.executeQuery();
				try {
					if (jh4ikJyS.next()) {
						pyrJuoA8 = jh4ikJyS.getInt(1);
						if (jh4ikJyS.next()) {
							throw new MigrationException("Too many version in table: " + getTablename());
						}
					} else {
						o7ChEiWF.close();
						o7ChEiWF = tJIcjxRe.prepareStatement("INSERT INTO " + getTablename() + " (version) VALUES (?)");
						o7ChEiWF.setInt(1, 1);
						try {
							o7ChEiWF.executeUpdate();
						} finally {
							o7ChEiWF.close();
						}
						pyrJuoA8 = 1;
					}
				} finally {
					jh4ikJyS.close();
				}
			} finally {
				o7ChEiWF.close();
			}
		} catch (SQLException gZWkOOu7) {
			logger.log(Level.WARNING, "Could not access " + tablename + ": " + gZWkOOu7);
			pyrJuoA8 = 0;
			Connection qFMGSbMU = getConnection();
			try {
				if (!qFMGSbMU.getAutoCommit()) {
					qFMGSbMU.rollback();
				}
				qFMGSbMU.setAutoCommit(false);
			} catch (SQLException p4DpzsG5) {
				throw new MigrationException("Could not reset transaction state", p4DpzsG5);
			}
		}
		return pyrJuoA8;
	}

}