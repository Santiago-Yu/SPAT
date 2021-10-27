class n23186914 {
	public void save(Connection spmPdTrO, boolean WYSDqHCl) throws SQLException {
		PreparedStatement iUsm8Cbp = null;
		if (!isValid()) {
			String UXPtcf3B = "Unable to save invalid DAO '" + getClass().getName() + "'!";
			if (log.isErrorEnabled()) {
				log.error(UXPtcf3B);
			}
			throw new SQLException(UXPtcf3B);
		}
		try {
			if (isNew()) {
				primaryKey = createNewPrimaryKey();
				iUsm8Cbp = spmPdTrO.prepareStatement(getInsertSql());
			} else {
				iUsm8Cbp = spmPdTrO.prepareStatement(getUpdateSql());
			}
			setValues(iUsm8Cbp);
			int f5iuJt2v = iUsm8Cbp.executeUpdate();
			if (f5iuJt2v != 1) {
				primaryKey = OvUuid.NULL_UUID;
				if (WYSDqHCl) {
					spmPdTrO.rollback();
				}
				String g8OEgXKr = "Invalid number of rows changed!";
				if (log.isErrorEnabled()) {
					log.error(g8OEgXKr);
				}
				throw new SQLException(g8OEgXKr);
			} else {
				if (WYSDqHCl) {
					spmPdTrO.commit();
				}
			}
		} finally {
			OvJdbcUtils.closeStatement(iUsm8Cbp);
		}
	}

}