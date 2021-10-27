class n21186038 {
	public Project deleteProject(int projectID) throws AdaptationException {
		Connection connection = null;
		Project project = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM Projects WHERE id = " + projectID;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to delete project failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM Projects WHERE id = " + projectID;
			project = getProject(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProject";
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
		return project;
	}

}