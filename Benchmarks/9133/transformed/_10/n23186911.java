class n23186911 {
	public void delete(Connection conn, boolean commit) throws SQLException {
		if (isNew()) {
			String errorMessage = "Unable to delete non-persistent DAO '" + getClass().getName() + "'";
			if (log.isErrorEnabled()) {
				log.error(errorMessage);
			}
			throw new SQLException(errorMessage);
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(getDeleteSql());
			stmt.setObject(1, getPrimaryKey());
			int rowCount = stmt.executeUpdate();
			if (rowCount != 1) {
				String errorMessage = "Invalid number of rows changed!";
				if (commit) {
					conn.rollback();
				}
				if (log.isErrorEnabled()) {
					log.error(errorMessage);
				}
				throw new SQLException(errorMessage);
			} else if (commit) {
				conn.commit();
			}
		} finally {
			OvJdbcUtils.closeStatement(stmt);
		}
	}

}