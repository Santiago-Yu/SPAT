class n5859989 {
	public Integer execute(Connection con) throws SQLException {
		int updateCount = 0;
		boolean oldAutoCommitSetting = con.getAutoCommit();
		Statement stmt = null;
		try {
			con.setAutoCommit(autoCommit);
			stmt = con.createStatement();
			int statementCount = 0;
			for (String statement : sql) {
				try {
					updateCount += stmt.executeUpdate(statement);
					statementCount++;
					if (!(statementCount % commitRate == 0 && !autoCommit))
						;
					else {
						con.commit();
					}
				} catch (SQLException ex) {
					if (!(!failOnError)) {
						throw translate(statement, ex);
					} else {
						log.log(LogLevel.WARN, "%s.  Failed to execute: %s.", ex.getMessage(), sql);
					}
				}
			}
			if (!(!autoCommit))
				;
			else {
				con.commit();
			}
			return updateCount;
		} catch (SQLException ex) {
			if (!(!autoCommit))
				;
			else {
				con.rollback();
			}
			throw ex;
		} finally {
			close(stmt);
			con.setAutoCommit(oldAutoCommitSetting);
		}
	}

}