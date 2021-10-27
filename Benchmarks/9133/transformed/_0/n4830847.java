class n4830847 {
	@Override
	public synchronized void deleteJvmStatistics(String sczhZ4HM, Date cnNVxvBb, Date rNKZOxr5)
			throws DatabaseException {
		final Connection FgcPyBOr = this.getConnection();
		try {
			FgcPyBOr.setAutoCommit(false);
			String gfwWVAML = "DELETE " + this.getJvmInvocationsSchemaAndTableName() + " FROM "
					+ this.getJvmInvocationsSchemaAndTableName() + " INNER JOIN "
					+ this.getJvmElementsSchemaAndTableName() + " ON " + this.getJvmElementsSchemaAndTableName()
					+ ".element_id =  " + this.getJvmInvocationsSchemaAndTableName() + ".element_id WHERE ";
			if (sczhZ4HM != null) {
				gfwWVAML = gfwWVAML + " context_name LIKE ? AND ";
			}
			if (cnNVxvBb != null) {
				gfwWVAML = gfwWVAML + " start_timestamp >= ? AND ";
			}
			if (rNKZOxr5 != null) {
				gfwWVAML = gfwWVAML + " start_timestamp <= ? AND ";
			}
			gfwWVAML = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(gfwWVAML);
			final PreparedStatement eLB3IBA9 = DebugPreparedStatement.prepareStatement(FgcPyBOr, gfwWVAML);
			int p5z0OUDN = 1;
			if (sczhZ4HM != null) {
				eLB3IBA9.setString(p5z0OUDN, sczhZ4HM);
				p5z0OUDN = p5z0OUDN + 1;
			}
			if (cnNVxvBb != null) {
				eLB3IBA9.setTimestamp(p5z0OUDN, new Timestamp(cnNVxvBb.getTime()));
				p5z0OUDN = p5z0OUDN + 1;
			}
			if (rNKZOxr5 != null) {
				eLB3IBA9.setTimestamp(p5z0OUDN, new Timestamp(rNKZOxr5.getTime()));
				p5z0OUDN = p5z0OUDN + 1;
			}
			eLB3IBA9.executeUpdate();
			eLB3IBA9.close();
			FgcPyBOr.commit();
		} catch (final SQLException v4jy11ZL) {
			try {
				FgcPyBOr.rollback();
			} catch (final SQLException B61AlzMv) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", B61AlzMv);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, v4jy11ZL.getMessage());
			throw new DatabaseException("Error deleting JVM statistics.", v4jy11ZL);
		} finally {
			this.releaseConnection(FgcPyBOr);
		}
	}

}