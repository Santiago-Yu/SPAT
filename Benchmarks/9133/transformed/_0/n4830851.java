class n4830851 {
	@Override
	protected void removeOrphansElements() throws DatabaseException {
		this.getIdChache().clear();
		final Connection WU7gcZ77 = this.getConnection();
		try {
			WU7gcZ77.setAutoCommit(false);
			PreparedStatement tGXJSbJH;
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getCallElementsSchemaAndTableName() + " FROM "
							+ this.getCallElementsSchemaAndTableName() + " LEFT JOIN "
							+ this.getCallInvocationsSchemaAndTableName() + " ON "
							+ this.getCallElementsSchemaAndTableName() + ".element_id =  "
							+ this.getCallInvocationsSchemaAndTableName() + ".element_id WHERE "
							+ this.getCallInvocationsSchemaAndTableName() + ".element_id IS NULL");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getCallExceptionsSchemaAndTableName() + " FROM "
							+ this.getCallExceptionsSchemaAndTableName() + " LEFT JOIN "
							+ this.getCallInvocationsSchemaAndTableName() + " ON "
							+ this.getCallExceptionsSchemaAndTableName() + ".exception_id =  "
							+ this.getCallInvocationsSchemaAndTableName() + ".exception_id WHERE "
							+ this.getCallInvocationsSchemaAndTableName() + ".exception_id IS NULL");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getCallPrincipalsSchemaAndTableName() + " FROM "
							+ this.getCallPrincipalsSchemaAndTableName() + " LEFT JOIN "
							+ this.getCallInvocationsSchemaAndTableName() + " ON "
							+ this.getCallPrincipalsSchemaAndTableName() + ".principal_id =  "
							+ this.getCallInvocationsSchemaAndTableName() + ".principal_id WHERE "
							+ this.getCallInvocationsSchemaAndTableName() + ".principal_id IS NULL");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getHttpSessionElementsSchemaAndTableName() + " FROM "
							+ this.getHttpSessionElementsSchemaAndTableName() + " LEFT JOIN "
							+ this.getHttpSessionInvocationsSchemaAndTableName() + " ON "
							+ this.getHttpSessionElementsSchemaAndTableName() + ".element_id =  "
							+ this.getHttpSessionInvocationsSchemaAndTableName() + ".element_id WHERE "
							+ this.getHttpSessionInvocationsSchemaAndTableName() + ".element_id IS NULL");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getJvmElementsSchemaAndTableName() + " FROM "
							+ this.getJvmElementsSchemaAndTableName() + " LEFT JOIN "
							+ this.getJvmInvocationsSchemaAndTableName() + " ON "
							+ this.getJvmElementsSchemaAndTableName() + ".element_id =  "
							+ this.getJvmInvocationsSchemaAndTableName() + ".element_id WHERE "
							+ this.getJvmInvocationsSchemaAndTableName() + ".element_id IS NULL");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getPersistenceEntityElementsSchemaAndTableName() + " FROM "
							+ this.getPersistenceEntityElementsSchemaAndTableName() + " LEFT JOIN "
							+ this.getPersistenceEntityStatisticsSchemaAndTableName() + " ON "
							+ this.getPersistenceEntityElementsSchemaAndTableName() + ".element_id =  "
							+ this.getPersistenceEntityStatisticsSchemaAndTableName() + ".element_id WHERE "
							+ this.getPersistenceEntityStatisticsSchemaAndTableName() + ".element_id IS NULL ");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getPersistenceQueryElementsSchemaAndTableName() + " FROM "
							+ this.getPersistenceQueryElementsSchemaAndTableName() + " LEFT JOIN "
							+ this.getPersistenceQueryStatisticsSchemaAndTableName() + " ON "
							+ this.getPersistenceQueryElementsSchemaAndTableName() + ".element_id =  "
							+ this.getPersistenceQueryStatisticsSchemaAndTableName() + ".element_id WHERE "
							+ this.getPersistenceQueryStatisticsSchemaAndTableName() + ".element_id IS NULL ");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			tGXJSbJH = DebugPreparedStatement.prepareStatement(WU7gcZ77,
					"DELETE " + this.getHardDiskElementsSchemaAndTableName() + " FROM "
							+ this.getHardDiskElementsSchemaAndTableName() + " LEFT JOIN "
							+ this.getHardDiskInvocationsSchemaAndTableName() + " ON "
							+ this.getHardDiskElementsSchemaAndTableName() + ".element_id =  "
							+ this.getHardDiskInvocationsSchemaAndTableName() + ".element_id WHERE "
							+ this.getHardDiskInvocationsSchemaAndTableName() + ".element_id IS NULL ");
			tGXJSbJH.executeUpdate();
			tGXJSbJH.close();
			WU7gcZ77.commit();
		} catch (final SQLException f1QIWJn3) {
			try {
				WU7gcZ77.rollback();
			} catch (final SQLException SQX7nE3U) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", SQX7nE3U);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, f1QIWJn3.getMessage());
			throw new DatabaseException("Error cleaning database.", f1QIWJn3);
		} finally {
			this.releaseConnection(WU7gcZ77);
		}
		return;
	}

}