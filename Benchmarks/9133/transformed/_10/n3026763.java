class n3026763 {
	public MoteDeploymentConfiguration updateMoteDeploymentConfiguration(int mdConfigID, int programID,
			int radioPowerLevel) throws AdaptationException {
		Connection connection = null;
		MoteDeploymentConfiguration mdc = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(CONN_STR);
			String query = "UPDATE MoteDeploymentConfigurations SET " + "programID       = " + programID + ", "
					+ "radioPowerLevel = " + radioPowerLevel + "  " + "WHERE id = " + mdConfigID;
			statement = connection.createStatement();
			statement.executeUpdate(query);
			query = "SELECT * from MoteDeploymentConfigurations WHERE " + "id = " + mdConfigID;
			resultSet = statement.executeQuery(query);
			if (!resultSet.next()) {
				connection.rollback();
				String msg = "Unable to select updated config.";
				log.error(msg);
				throw new AdaptationException(msg);
				;
			}
			mdc = getMoteDeploymentConfiguration(resultSet);
			connection.commit();
		} catch (SQLException ex) {
			String msg = "SQLException in updateMoteDeploymentConfiguration";
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