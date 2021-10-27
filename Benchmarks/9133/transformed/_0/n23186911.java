class n23186911 {
	public void delete(Connection Jt5g6wYx, boolean kFtgOSUQ) throws SQLException {
		PreparedStatement qRSA6T5g = null;
		if (isNew()) {
			String A16Bcjx5 = "Unable to delete non-persistent DAO '" + getClass().getName() + "'";
			if (log.isErrorEnabled()) {
				log.error(A16Bcjx5);
			}
			throw new SQLException(A16Bcjx5);
		}
		try {
			qRSA6T5g = Jt5g6wYx.prepareStatement(getDeleteSql());
			qRSA6T5g.setObject(1, getPrimaryKey());
			int aGyULETz = qRSA6T5g.executeUpdate();
			if (aGyULETz != 1) {
				if (kFtgOSUQ) {
					Jt5g6wYx.rollback();
				}
				String NPFrSXaD = "Invalid number of rows changed!";
				if (log.isErrorEnabled()) {
					log.error(NPFrSXaD);
				}
				throw new SQLException(NPFrSXaD);
			} else if (kFtgOSUQ) {
				Jt5g6wYx.commit();
			}
		} finally {
			OvJdbcUtils.closeStatement(qRSA6T5g);
		}
	}

}