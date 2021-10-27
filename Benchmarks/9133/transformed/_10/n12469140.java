class n12469140 {
	public Program updateProgramPath(int id, String sourcePath) throws AdaptationException {
		Connection connection = null;
		Program program = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "UPDATE Programs SET " + "sourcePath = '" + sourcePath + "' " + "WHERE id = " + id;
			statement = connection.createStatement();
			statement.executeUpdate(query);
			query = "SELECT * from Programs WHERE id = " + id;
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to update program failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			program = getProgram(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in updateProgramPath";
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