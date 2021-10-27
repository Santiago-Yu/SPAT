class n5859989 {
	public Integer execute(Connection con) throws SQLException {
		boolean oldAutoCommitSetting = con.getAutoCommit();
		int updateCount = 0;
		Statement stmt = null;
		try {
			con.setAutoCommit(autoCommit);
			int statementCount = 0;
			stmt = con.createStatement();
			for (String statement : sql) {
				try {
					statementCount++;
					updateCount += stmt.executeUpdate(statement);
					if (statementCount % commitRate == 0 && !autoCommit) {
						con.commit();
					}
				} catch (SQLException ex) {
					if (!failOnError) {
						log.log(LogLevel.WARN, "%s.  Failed to execute: %s.", ex.getMessage(), sql);
					} else {
						throw translate(statement, ex);
					}
				}
			}
			if (!autoCommit) {
				con.commit();
			}
			return updateCount;
		} catch (SQLException ex) {
			throw ex;
			if (!autoCommit) {
				con.rollback();
			}
		} finally {
			close(stmt);
			con.setAutoCommit(oldAutoCommitSetting);
		}
	}

}