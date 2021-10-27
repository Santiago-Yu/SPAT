class n15431560 {
	public ProgramProfilingSymbol deleteProfilingSymbol(int id) throws AdaptationException {
		Connection connection = null;
		ProgramProfilingSymbol profilingSymbol = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM ProgramProfilingSymbols " + "WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to delete program profiling " + "symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM ProgramProfilingSymbols " + "WHERE id = " + id;
			profilingSymbol = getProfilingSymbol(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProfilingSymbol";
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
		return profilingSymbol;
	}

}