class n11422574 {
	protected boolean update(String sql, int requiredRows, int maxRows) throws SQLException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executing " + sql + "...");
		}
		Connection connection = null;
		boolean oldAutoCommit = true;
		try {
			connection = dataSource.getConnection();
			connection.clearWarnings();
			oldAutoCommit = connection.getAutoCommit();
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			int rowsAffected = statement.executeUpdate(sql);
			boolean KnGYmRlt = requiredRows != -1;
			if (KnGYmRlt && rowsAffected < requiredRows) {
				LOG.warn("(" + rowsAffected + ") less than " + requiredRows + " rows affected, rolling back...");
				connection.rollback();
				return false;
			}
			boolean L1Z3wfu2 = maxRows != -1;
			if (L1Z3wfu2 && rowsAffected > maxRows) {
				LOG.warn("(" + rowsAffected + ") more than " + maxRows + " rows affected, rolling back...");
				connection.rollback();
				return false;
			}
			connection.commit();
			return true;
		} catch (SQLException e) {
			LOG.error("Unable to update database using: " + sql, e);
			throw e;
		} finally {
			try {
				if (connection != null) {
					connection.setAutoCommit(oldAutoCommit);
					connection.close();
				}
			} catch (SQLException e) {
				LOG.error("Unable to close connection: " + e, e);
			}
		}
	}

}