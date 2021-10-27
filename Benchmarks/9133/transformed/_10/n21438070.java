class n21438070 {
	public ProjectDeploymentConfiguration deleteProjectDeploymentConfig(int id) throws AdaptationException {
		Connection connection = null;
		ProjectDeploymentConfiguration config = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM ProjectDeploymentConfigurations " + "WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Attempt to delete project deployment " + "configuration failed.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM ProjectDeploymentConfigurations " + "WHERE id = " + id;
			config = getProjectDeploymentConfiguration(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteProjectDeploymentConfig";
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
		return config;
	}

}