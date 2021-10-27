class n4830848 {
	@Override
	public synchronized void deletePersistenceEntityStatistics(Integer elementId, String contextName, String project,
			String name, Date dateFrom, Date dateTo) throws DatabaseException {
		final Connection connection = this.getConnection();
		try {
			connection.setAutoCommit(false);
			String queryString = "DELETE " + this.getPersistenceEntityStatisticsSchemaAndTableName() + " FROM "
					+ this.getPersistenceEntityStatisticsSchemaAndTableName() + " INNER JOIN "
					+ this.getPersistenceEntityElementsSchemaAndTableName() + " ON "
					+ this.getPersistenceEntityElementsSchemaAndTableName() + ".element_id =  "
					+ this.getPersistenceEntityStatisticsSchemaAndTableName() + ".element_id WHERE ";
			queryString = (elementId != null) ? queryString + " elementId = ? AND " : queryString;
			queryString = (contextName != null) ? queryString + " context_name LIKE ? AND " : queryString;
			queryString = ((project != null)) ? queryString + " project LIKE ? AND " : queryString;
			queryString = ((name != null)) ? queryString + " name LIKE ? AND " : queryString;
			queryString = (dateFrom != null) ? queryString + " start_timestamp >= ? AND " : queryString;
			queryString = (dateTo != null) ? queryString + " start_timestamp <= ? AND " : queryString;
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
			throw new DatabaseException("Error deleting persistence entity statistics.", e);
		} finally {
			this.releaseConnection(connection);
		}
	}

}