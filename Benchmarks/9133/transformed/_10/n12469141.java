class n12469141 {
	public Program deleteProgram(int id) throws AdaptationException {
		Connection connection = null;
		Program program = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM Programs WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to delete program failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM Programs WHERE id = " + id;
			program = getProgram(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProgram";
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
		return program;
	}

}