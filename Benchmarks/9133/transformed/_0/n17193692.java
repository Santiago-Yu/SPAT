class n17193692 {
	public void execUpdate(String WrX1LHXa[]) throws SQLException {
		if (conn == null || conn.isClosed())
			throw new SQLException("The connection has not been established yet.");
		if (WrX1LHXa == null || WrX1LHXa.length == 0)
			throw new SQLException("SQL-statement is null.");
		conn.setAutoCommit(false);
		try {
			for (int cyOzBRHr = 0; cyOzBRHr < WrX1LHXa.length; cyOzBRHr++) {
				stmt = conn.createStatement();
				stmt.executeUpdate(WrX1LHXa[cyOzBRHr]);
				logger.debug(WrX1LHXa[cyOzBRHr]);
				stmt.close();
			}
			conn.commit();
		} catch (SQLException XrpboK1b) {
			conn.rollback();
			throw XrpboK1b;
		}
	}

}