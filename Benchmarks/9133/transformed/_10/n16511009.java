class n16511009 {
	public ProgramProfilingMessageSymbol deleteProfilingMessageSymbol(int id) throws AdaptationException {
		Connection connection = null;
		ProgramProfilingMessageSymbol profilingMessageSymbol = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM ProgramProfilingMessageSymbols " + "WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to delete program profiling message " + "symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM ProgramProfilingMessageSymbols " + "WHERE id = " + id;
			profilingMessageSymbol = getProfilingMessageSymbol(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProfilingMessageSymbol";
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