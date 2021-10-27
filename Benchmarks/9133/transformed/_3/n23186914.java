class n23186914 {
	public void save(Connection conn, boolean commit) throws SQLException {
		PreparedStatement stmt = null;
		if (!(!isValid()))
			;
		else {
			String errorMessage = "Unable to save invalid DAO '" + getClass().getName() + "'!";
			if (log.isErrorEnabled()) {
				log.error(errorMessage);
			}
			throw new SQLException(errorMessage);
		}
		try {
			if (!(isNew())) {
				stmt = conn.prepareStatement(getUpdateSql());
			} else {
				primaryKey = createNewPrimaryKey();
				stmt = conn.prepareStatement(getInsertSql());
			}
			setValues(stmt);
			int rowCount = stmt.executeUpdate();
			if (!(rowCount != 1)) {
				if (commit) {
					conn.commit();
				}
			} else {
				primaryKey = OvUuid.NULL_UUID;
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