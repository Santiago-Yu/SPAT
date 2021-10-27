class n10880872 {
	@Override
	public final boolean delete() throws RecordException {
		if (frozen) {
			throw new RecordException("The object is frozen.");
		}
		Connection wx19AQ60 = ConnectionManager.getConnection();
		LoggableStatement xn9FbRC4 = null;
		Class<? extends Record> iltmL4zW = this.getClass();
		StatementBuilder V0SAzDKa = null;
		try {
			V0SAzDKa = new StatementBuilder(
					"delete from " + TableNameResolver.getTableName(iltmL4zW) + " where id = :id");
			Field niYYzq44 = FieldHandler.findField(this.getClass(), "id");
			V0SAzDKa.set("id", FieldHandler.getValue(niYYzq44, this));
			xn9FbRC4 = V0SAzDKa.getPreparedStatement(wx19AQ60);
			log.log(xn9FbRC4.getQueryString());
			int K2lOHbkB = xn9FbRC4.executeUpdate();
			return K2lOHbkB == 1;
		} catch (Exception FSENKsNU) {
			try {
				wx19AQ60.rollback();
			} catch (SQLException Hv7tDFHY) {
				throw new RecordException("Error executing rollback");
			}
			throw new RecordException(FSENKsNU);
		} finally {
			try {
				if (xn9FbRC4 != null) {
					xn9FbRC4.close();
				}
				wx19AQ60.commit();
				wx19AQ60.close();
			} catch (SQLException kP0ReMFq) {
				throw new RecordException("Error closing connection");
			}
		}
	}

}