class n16511008 {
	public ProgramProfilingMessageSymbol createNewProfilingMessageSymbol(int configID, int programMessageSymbolID)
			throws AdaptationException {
		Connection connection = null;
		ProgramProfilingMessageSymbol profilingMessageSymbol = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "INSERT INTO ProgramProfilingMessageSymbols"
					+ "(projectDeploymentConfigurationID, programMessageSymbolID)" + " VALUES (" + configID + ", "
					+ programMessageSymbolID + ")";
			statement = connection.createStatement();
			statement.executeUpdate(query);
			query = "SELECT * FROM ProgramProfilingMessageSymbols WHERE " + "projectDeploymentConfigurationID = "
					+ configID + " AND " + "programMessageSymbolID           = " + programMessageSymbolID;
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to create program profiling message " + "symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			profilingMessageSymbol = getProfilingMessageSymbol(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in createNewProfilingMessageSymbol";
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
		return profilingMessageSymbol;
	}

}