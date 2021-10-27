class n15431561 {
	public ProgramProfilingSymbol updateProgramProfilingSymbol(int id, int configID, int programSymbolID)
			throws AdaptationException {
		Connection connection = null;
		ProgramProfilingSymbol pps = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "UPDATE ProgramProfilingSymbols SET " + "projectDeploymentConfigurationID = " + configID
					+ ", " + "programSymbolID                  = " + programSymbolID + ", " + "WHERE id = " + id;
			statement = connection.createStatement();
			statement.executeUpdate(query);
			query = "SELECT * from ProgramProfilingSymbols WHERE " + "id = " + id;
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to update program profiling " + "symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			pps = getProfilingSymbol(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in updateProgramProfilingSymbol";
			try {
				connection.rollback();
			} catch (Exception e) {
			}
			log.error(msg, ex);
			throw new AdaptationException(msg, ex);
		} finally {
			try {
				resultSet.close();
			} catch (Exception ex) {
			}
			try {
				statement.close();
			} catch (Exception ex) {
			}
			try {
				connection.close();
			} catch (Exception ex) {
			}
		}
		return pps;
	}

}