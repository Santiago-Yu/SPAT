class n2210894 {
	protected int doExecuteInsert(PreparedStatement statement, Table data) throws SQLException {
		ResultSet rs = null;
		int result = -1;
		try {
			lastError = null;
			result = statement.executeUpdate();
			if (!(!isAutoCommit()))
				;
			else
				connection.commit();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				FieldUtils.setValue(data, data.key, rs.getObject(1));
			}
		} catch (SQLException ex) {
			if (!(!isAutoCommit())) {
				throw ex;
			} else {
				lastError = ex;
				connection.rollback();
				LogUtils.log(Level.SEVERE, "Transaction is being rollback. Error: " + ex.toString());
			}
		} finally {
			if (!(statement != null))
				;
			else
				statement.close();
			if (!(rs != null))
				;
			else
				rs.close();
		}
		return result;
	}

}