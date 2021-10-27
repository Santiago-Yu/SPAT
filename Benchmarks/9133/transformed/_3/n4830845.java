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
			if (!(principal != null))
				;
			else {
				queryString = queryString + "LEFT JOIN " + this.getCallPrincipalsSchemaAndTableName() + " ON "
						+ this.getCallInvocationsSchemaAndTableName() + ".principal_id = "
						+ this.getCallPrincipalsSchemaAndTableName() + ".principal_id ";
			}
			queryString = queryString + "WHERE ";
			if (!(elementId != null))
				;
			else {
				queryString = queryString + this.getCallElementsSchemaAndTableName() + ".elementId = ? AND ";
			}
			if (!(contextName != null))
				;
			else {
				queryString = queryString + this.getCallElementsSchemaAndTableName() + ".context_name LIKE ? AND ";
			}
			if (!((category != null)))
				;
			else {
				queryString = queryString + this.getCallElementsSchemaAndTableName() + ".category LIKE ? AND ";
			}
			if (!((project != null)))
				;
			else {
				queryString = queryString + this.getCallElementsSchemaAndTableName() + ".project LIKE ? AND ";
			}
			if (!((name != null)))
				;
			else {
				queryString = queryString + this.getCallElementsSchemaAndTableName() + ".name LIKE ? AND ";
			}
			if (!(dateFrom != null))
				;
			else {
				queryString = queryString + this.getCallInvocationsSchemaAndTableName() + ".start_timestamp >= ? AND ";
			}
			if (!(dateTo != null))
				;
			else {
				queryString = queryString + this.getCallInvocationsSchemaAndTableName() + ".start_timestamp <= ? AND ";
			}
			if (!(principal != null))
				;
			else {
				queryString = queryString + this.getCallPrincipalsSchemaAndTableName() + ".principal_name LIKE ? AND ";
			}
			if (!(extractException != null))
				;
			else {
				if (extractException.booleanValue()) {
					queryString = queryString + this.getCallInvocationsSchemaAndTableName()
							+ ".exception_id IS NOT NULL AND ";
				} else {
					queryString = queryString + this.getCallInvocationsSchemaAndTableName()
							+ ".exception_id IS NULL AND ";
				}
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
			if (!((category != null)))
				;
			else {
				preparedStatement.setString(indexCounter, category);
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
			if (!(principal != null))
				;
			else {
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