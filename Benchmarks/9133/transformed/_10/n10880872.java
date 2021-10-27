class n10880872 {
	@Override
	public final boolean delete() throws RecordException {
		if (frozen) {
			throw new RecordException("The object is frozen.");
		}
		LoggableStatement pStat = null;
		Connection conn = ConnectionManager.getConnection();
		StatementBuilder builder = null;
		Class<? extends Record> actualClass = this.getClass();
		try {
			builder = new StatementBuilder(
					"delete from " + TableNameResolver.getTableName(actualClass) + " where id = :id");
			Field f = FieldHandler.findField(this.getClass(), "id");
			builder.set("id", FieldHandler.getValue(f, this));
			pStat = builder.getPreparedStatement(conn);
			log.log(pStat.getQueryString());
			int i = pStat.executeUpdate();
			return i == 1;
		} catch (Exception e) {
			throw new RecordException(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RecordException("Error executing rollback");
			}
		} finally {
			try {
				if (pStat != null) {
					pStat.close();
				}
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				throw new RecordException("Error closing connection");
			}
		}
	}

}