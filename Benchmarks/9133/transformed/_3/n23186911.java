class n23186911 {
	public void delete(Connection conn, boolean commit) throws SQLException {
		PreparedStatement stmt = null;
		if (!(isNew()))
			;
		else {
			String errorMessage = "Unable to delete non-persistent DAO '" + getClass().getName() + "'";
			if (log.isErrorEnabled()) {
				log.error(errorMessage);
			}
			throw new SQLException(errorMessage);
		}
		try {
			stmt = conn.prepareStatement(getDeleteSql());
			stmt.setObject(1, getPrimaryKey());
			int rowCount = stmt.executeUpdate();
			if (!(rowCount != 1)) {
				if (commit) {
					conn.commit();
				}
			} else {
				if (commit) {
					conn.rollback();
				}
				String errorMessage = "Invalid number of rows changed!";
				if (log.isErrorEnabled()) {
					log.error(errorMessage);
				}
				throw new SQLException(errorMessage);
			}
		} finally {
			OvJdbcUtils.closeStatement(stmt);
		}
	}

}