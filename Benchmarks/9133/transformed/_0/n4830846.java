class n4830846 {
	@Override
	public synchronized void deleteHttpSessionStatistics(String qxa6hQFi, String iUu76Fi9, Date izhpIuPk, Date i7BiQtwW)
			throws DatabaseException {
		final Connection qRmHg7Gp = this.getConnection();
		try {
			qRmHg7Gp.setAutoCommit(false);
			String tgSkACMS = "DELETE " + this.getHttpSessionInvocationsSchemaAndTableName() + " FROM "
					+ this.getHttpSessionInvocationsSchemaAndTableName() + " INNER JOIN "
					+ this.getHttpSessionElementsSchemaAndTableName() + " ON "
					+ this.getHttpSessionElementsSchemaAndTableName() + ".element_id =  "
					+ this.getHttpSessionInvocationsSchemaAndTableName() + ".element_id WHERE ";
			if (qxa6hQFi != null) {
				tgSkACMS = tgSkACMS + " context_name LIKE ? AND ";
			}
			if (iUu76Fi9 != null) {
				tgSkACMS = tgSkACMS + " project LIKE ? AND ";
			}
			if (izhpIuPk != null) {
				tgSkACMS = tgSkACMS + " start_timestamp >= ? AND ";
			}
			if (i7BiQtwW != null) {
				tgSkACMS = tgSkACMS + " start_timestamp <= ? AND ";
			}
			tgSkACMS = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(tgSkACMS);
			final PreparedStatement RJaH017M = DebugPreparedStatement.prepareStatement(qRmHg7Gp, tgSkACMS);
			int Y0KIUsF8 = 1;
			if (qxa6hQFi != null) {
				RJaH017M.setString(Y0KIUsF8, qxa6hQFi);
				Y0KIUsF8 = Y0KIUsF8 + 1;
			}
			if (iUu76Fi9 != null) {
				RJaH017M.setString(Y0KIUsF8, iUu76Fi9);
				Y0KIUsF8 = Y0KIUsF8 + 1;
			}
			if (izhpIuPk != null) {
				RJaH017M.setTimestamp(Y0KIUsF8, new Timestamp(izhpIuPk.getTime()));
				Y0KIUsF8 = Y0KIUsF8 + 1;
			}
			if (i7BiQtwW != null) {
				RJaH017M.setTimestamp(Y0KIUsF8, new Timestamp(i7BiQtwW.getTime()));
				Y0KIUsF8 = Y0KIUsF8 + 1;
			}
			RJaH017M.executeUpdate();
			RJaH017M.close();
			qRmHg7Gp.commit();
		} catch (final SQLException Q05ytYYA) {
			try {
				qRmHg7Gp.rollback();
			} catch (final SQLException EBN7bUf1) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", EBN7bUf1);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, Q05ytYYA.getMessage());
			throw new DatabaseException("Error deleting HTTP session statistics.", Q05ytYYA);
		} finally {
			this.releaseConnection(qRmHg7Gp);
		}
	}

}