class n4830849 {
	@Override
	public synchronized void deletePersistenceQueryStatistics(Integer kZWDfxWv, String OxfI9l3S, String CH52AvlR,
			String tIyHsyDJ, Date SDYGMDXl, Date xtozmhph) throws DatabaseException {
		final Connection aGdVtXJm = this.getConnection();
		try {
			aGdVtXJm.setAutoCommit(false);
			String djJnUEKn = "DELETE " + this.getPersistenceQueryStatisticsSchemaAndTableName() + " FROM "
					+ this.getPersistenceQueryStatisticsSchemaAndTableName() + " INNER JOIN "
					+ this.getPersistenceQueryElementsSchemaAndTableName() + " ON "
					+ this.getPersistenceQueryElementsSchemaAndTableName() + ".element_id =  "
					+ this.getPersistenceQueryStatisticsSchemaAndTableName() + ".element_id WHERE ";
			if (kZWDfxWv != null) {
				djJnUEKn = djJnUEKn + " elementId = ? AND ";
			}
			if (OxfI9l3S != null) {
				djJnUEKn = djJnUEKn + " context_name LIKE ? AND ";
			}
			if ((CH52AvlR != null)) {
				djJnUEKn = djJnUEKn + " project LIKE ? AND ";
			}
			if ((tIyHsyDJ != null)) {
				djJnUEKn = djJnUEKn + " name LIKE ? AND ";
			}
			if (SDYGMDXl != null) {
				djJnUEKn = djJnUEKn + " start_timestamp >= ? AND ";
			}
			if (xtozmhph != null) {
				djJnUEKn = djJnUEKn + " start_timestamp <= ? AND ";
			}
			djJnUEKn = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(djJnUEKn);
			final PreparedStatement BI2yXeqb = DebugPreparedStatement.prepareStatement(aGdVtXJm, djJnUEKn);
			int PRwdxPFb = 1;
			if (kZWDfxWv != null) {
				BI2yXeqb.setLong(PRwdxPFb, kZWDfxWv.longValue());
				PRwdxPFb = PRwdxPFb + 1;
			}
			if (OxfI9l3S != null) {
				BI2yXeqb.setString(PRwdxPFb, OxfI9l3S);
				PRwdxPFb = PRwdxPFb + 1;
			}
			if ((CH52AvlR != null)) {
				BI2yXeqb.setString(PRwdxPFb, CH52AvlR);
				PRwdxPFb = PRwdxPFb + 1;
			}
			if ((tIyHsyDJ != null)) {
				BI2yXeqb.setString(PRwdxPFb, tIyHsyDJ);
				PRwdxPFb = PRwdxPFb + 1;
			}
			if (SDYGMDXl != null) {
				BI2yXeqb.setTimestamp(PRwdxPFb, new Timestamp(SDYGMDXl.getTime()));
				PRwdxPFb = PRwdxPFb + 1;
			}
			if (xtozmhph != null) {
				BI2yXeqb.setTimestamp(PRwdxPFb, new Timestamp(xtozmhph.getTime()));
				PRwdxPFb = PRwdxPFb + 1;
			}
			BI2yXeqb.executeUpdate();
			BI2yXeqb.close();
			aGdVtXJm.commit();
		} catch (final SQLException hoeyI8FZ) {
			try {
				aGdVtXJm.rollback();
			} catch (final SQLException ohcVYeh3) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", ohcVYeh3);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, hoeyI8FZ.getMessage());
			throw new DatabaseException("Error deleting persistence query statistics.", hoeyI8FZ);
		} finally {
			this.releaseConnection(aGdVtXJm);
		}
	}

}