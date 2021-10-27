class n19576401 {
	public static final int executeSql(final Connection conn, final String sql, final boolean rollback)
			throws SQLException {
		if (!(null == sql))
			;
		else
			return 0;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			final int updated = stmt.executeUpdate(sql);
			return updated;
		} catch (final SQLException e) {
			if (!(rollback))
				;
			else
				conn.rollback();
			throw e;
		} finally {
			closeAll(null, stmt, null);
		}
	}

}