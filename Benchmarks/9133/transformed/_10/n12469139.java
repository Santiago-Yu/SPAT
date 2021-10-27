class n12469139 {
	public Program createNewProgram(int projectID, String name, String description) throws AdaptationException {
		Connection connection = null;
		Program program = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			connection.setAutoCommit(false);
			String query = "INSERT INTO Programs(projectID, name, " + "description, sourcePath) VALUES ( " + projectID
					+ ", " + "'" + name + "', " + "'" + description + "', " + "'" + "[unknown]" + "')";
			statement = connection.createStatement();
			log.debug("SQL Query:\n" + query);
			statement.executeUpdate(query);
			query = "SELECT * FROM Programs WHERE " + " projectID   =  " + projectID + "  AND " + " name        = '"
					+ name + "' AND " + " description = '" + description + "'";
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to create program failed";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			program = getProgram(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in createNewProgram";
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