class n19576401 {
	public static final int executeSql(final Connection conn, final String sql, final boolean rollback)
			throws SQLException {
		Statement stmt = null;
		if (null == sql)
			return 0;
		try {
			stmt = conn.createStatement();
			final int updated = stmt.executeUpdate(sql);
			return updated;
		} catch (final SQLException e) {
			throw e;
			if (rollback)
				conn.rollback();
		} finally {
			closeAll(null, stmt, null);
		}
	}

}