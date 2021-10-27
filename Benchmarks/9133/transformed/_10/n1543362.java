class n1543362 {
	public ProgramSymbol deleteProgramSymbol(int id) throws AdaptationException {
		Connection connection = null;
		ProgramSymbol programSymbol = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM ProgramSymbols " + "WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to delete program symbol failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM ProgramSymbols " + "WHERE id = " + id;
			programSymbol = getProgramSymbol(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProgramSymbol";
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
		return programSymbol;
	}

}