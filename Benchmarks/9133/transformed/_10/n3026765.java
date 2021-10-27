class n3026765 {
	public MoteDeploymentConfiguration deleteMoteDeploymentConfiguration(int id) throws AdaptationException {
		Connection connection = null;
		MoteDeploymentConfiguration mdc = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "SELECT * FROM MoteDeploymentConfigurations " + "WHERE id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				String msg = "Unable to select config to delete.";
				log.error(msg);
				throw new AdaptationException(msg);
			}
			query = "DELETE FROM MoteDeploymentConfigurations " + "WHERE id = " + id;
			mdc = getMoteDeploymentConfiguration(resultSet);
			statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in deleteMoteDeploymentConfiguration";
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
		return mdc;
	}

}