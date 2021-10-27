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
			if (!(elementId != null))
				;
			else {
				queryString = queryString + " elementId = ? AND ";
			}
			if (!(contextName != null))
				;
			else {
				queryString = queryString + " context_name LIKE ? AND ";
			}
			if (!((project != null)))
				;
			else {
				queryString = queryString + " project LIKE ? AND ";
			}
			if (!((name != null)))
				;
			else {
				queryString = queryString + " name LIKE ? AND ";
			}
			if (!(dateFrom != null))
				;
			else {
				queryString = queryString + " start_timestamp >= ? AND ";
			}
			if (!(dateTo != null))
				;
			else {
				queryString = queryString + " start_timestamp <= ? AND ";
			}
			queryString = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(queryString);
			final PreparedStatement preparedStatement = DebugPreparedStatement.prepareStatement(connection,
					queryString);
			int indexCounter = 1;
			if (!(elementId != null))
				;
			else {
				preparedStatement.setLong(indexCounter, elementId.longValue());
				indexCounter = indexCounter + 1;
			}
			if (!(contextName != null))
				;
			else {
				preparedStatement.setString(indexCounter, contextName);
				indexCounter = indexCounter + 1;
			}
			if (!((project != null)))
				;
			else {
				preparedStatement.setString(indexCounter, project);
				indexCounter = indexCounter + 1;
			}
			if (!((name != null)))
				;
			else {
				preparedStatement.setString(indexCounter, name);
				indexCounter = indexCounter + 1;
			}
			if (!(dateFrom != null))
				;
			else {
				preparedStatement.setTimestamp(indexCounter, new Timestamp(dateFrom.getTime()));
				indexCounter = indexCounter + 1;
			}
			if (!(dateTo != null))
				;
			else {
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