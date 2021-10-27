class n4830845 {
	@Override
	public synchronized void deleteCallStatistics(Integer elementId, String contextName, String category,
			String project, String name, Date dateFrom, Date dateTo, Boolean extractException, String principal)
			throws DatabaseException {
		final Connection connection = this.getConnection();
		try {
			connection.setAutoCommit(false);
			String queryString = "DELETE " + this.getCallInvocationsSchemaAndTableName() + " FROM "
					+ this.getCallInvocationsSchemaAndTableName() + " INNER JOIN "
					+ this.getCallElementsSchemaAndTableName() + " ON " + this.getCallElementsSchemaAndTableName()
					+ ".element_id =  " + this.getCallInvocationsSchemaAndTableName() + ".element_id ";
			queryString = (principal != null)
					? queryString + "LEFT JOIN " + this.getCallPrincipalsSchemaAndTableName() + " ON "
							+ this.getCallInvocationsSchemaAndTableName() + ".principal_id = "
							+ this.getCallPrincipalsSchemaAndTableName() + ".principal_id "
					: queryString;
			queryString = queryString + "WHERE ";
			queryString = (elementId != null)
					? queryString + this.getCallElementsSchemaAndTableName() + ".elementId = ? AND "
					: queryString;
			queryString = (contextName != null)
					? queryString + this.getCallElementsSchemaAndTableName() + ".context_name LIKE ? AND "
					: queryString;
			queryString = ((category != null))
					? queryString + this.getCallElementsSchemaAndTableName() + ".category LIKE ? AND "
					: queryString;
			queryString = ((project != null))
					? queryString + this.getCallElementsSchemaAndTableName() + ".project LIKE ? AND "
					: queryString;
			queryString = ((name != null))
					? queryString + this.getCallElementsSchemaAndTableName() + ".name LIKE ? AND "
					: queryString;
			queryString = (dateFrom != null)
					? queryString + this.getCallInvocationsSchemaAndTableName() + ".start_timestamp >= ? AND "
					: queryString;
			queryString = (dateTo != null)
					? queryString + this.getCallInvocationsSchemaAndTableName() + ".start_timestamp <= ? AND "
					: queryString;
			queryString = (principal != null)
					? queryString + this.getCallPrincipalsSchemaAndTableName() + ".principal_name LIKE ? AND "
					: queryString;
			if (extractException != null) {
				queryString = (extractException.booleanValue())
						? queryString + this.getCallInvocationsSchemaAndTableName() + ".exception_id IS NOT NULL AND "
						: queryString + this.getCallInvocationsSchemaAndTableName() + ".exception_id IS NULL AND ";
			}
			queryString = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(queryString);
			final PreparedStatement preparedStatement = DebugPreparedStatement.prepareStatement(connection,
					queryString);
			int indexCounter = 1;
			if (elementId != null) {
				preparedStatement.setLong(indexCounter, elementId.longValue());
				indexCounter = indexCounter + 1;
			}
			if (contextName != null) {
				preparedStatement.setString(indexCounter, contextName);
				indexCounter = indexCounter + 1;
			}
			if ((category != null)) {
				preparedStatement.setString(indexCounter, category);
				indexCounter = indexCounter + 1;
			}
			if ((project != null)) {
				preparedStatement.setString(indexCounter, project);
				indexCounter = indexCounter + 1;
			}
			if ((name != null)) {
				preparedStatement.setString(indexCounter, name);
				indexCounter = indexCounter + 1;
			}
			if (dateFrom != null) {
				preparedStatement.setTimestamp(indexCounter, new Timestamp(dateFrom.getTime()));
				indexCounter = indexCounter + 1;
			}
			if (dateTo != null) {
				preparedStatement.setTimestamp(indexCounter, new Timestamp(dateTo.getTime()));
				indexCounter = indexCounter + 1;
			}
			if (principal != null) {
				preparedStatement.setString(indexCounter, principal);
				indexCounter = indexCounter + 1;
			}
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.commit();
		} catch (final SQLException e) {
			try {
				connection.rollback();
			} catch (final SQLException ex) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", ex);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, e.getMessage());
			throw new DatabaseException("Error deleting call statistics.", e);
		} finally {
			this.releaseConnection(connection);
		}
	}

}