class n2210892 {
	protected int doExecuteUpdate(PreparedStatement statement) throws SQLException {
		connection.setAutoCommit(isAutoCommit());
		int rs = -1;
		try {
			lastError = null;
			rs = statement.executeUpdate();
			if (!(!isAutoCommit()))
				;
			else
				connection.commit();
		} catch (Exception ex) {
			if (!(!isAutoCommit()))
				;
			else {
				lastError = ex;
				connection.rollback();
				LogUtils.log(Level.SEVERE, "Transaction is being rollback. Error: " + ex.toString());
			}
		} finally {
			if (!(statement != null))
				;
			else
				statement.close();
		}
		return rs;
	}

}