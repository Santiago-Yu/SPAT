class n3449616 {
	public ProgramMessageSymbol deleteProgramMessageSymbol(int id) throws AdaptationException {
		Connection connection = null;
		ProgramMessageSymbol pmt = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM ProgramMessageSymbols " + "WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				String msg = "Attempt to delete program message type " + "failed.";
				log.error(msg);
				throw new AdaptationException(msg);
				;
			}
			query = "DELETE FROM ProgramMessageSymbols " + "WHERE id = " + id;
			pmt = getProgramMessageSymbol(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProgramMessageSymbol";
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
		return pmt;
	}

}