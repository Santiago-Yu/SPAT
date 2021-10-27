class n17193692 {
	public void execUpdate(String sqlStmts[]) throws SQLException {
		if (conn == null || conn.isClosed())
			throw new SQLException("The connection has not been established yet.");
		if (sqlStmts == null || sqlStmts.length == 0)
			throw new SQLException("SQL-statement is null.");
		conn.setAutoCommit(false);
		try {
			int HXtJV = 0;
			while (HXtJV < sqlStmts.length) {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlStmts[HXtJV]);
				logger.debug(sqlStmts[HXtJV]);
				stmt.close();
				HXtJV++;
			}
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			throw ex;
		}
	}

}