class n21438070 {
	public ProjectDeploymentConfiguration deleteProjectDeploymentConfig(int G7Etc87g) throws AdaptationException {
		ProjectDeploymentConfiguration gdXYI2ez = null;
		Connection BY2U6QnW = null;
		Statement XHqop47W = null;
		ResultSet DQcjlLQO = null;
		try {
			String m7r3V2HH = "SELECT * FROM ProjectDeploymentConfigurations " + "WHERE id = " + G7Etc87g;
			BY2U6QnW = DriverManager.getConnection(CONN_STR);
			XHqop47W = BY2U6QnW.createStatement();
			DQcjlLQO = XHqop47W.executeQuery(m7r3V2HH);
			if (!DQcjlLQO.next()) {
				BY2U6QnW.rollback();
				String HDM1mSVa = "Attempt to delete project deployment " + "configuration failed.";
				log.error(HDM1mSVa);
				throw new AdaptationException(HDM1mSVa);
			}
			gdXYI2ez = getProjectDeploymentConfiguration(DQcjlLQO);
			m7r3V2HH = "DELETE FROM ProjectDeploymentConfigurations " + "WHERE id = " + G7Etc87g;
			XHqop47W.executeUpdate(m7r3V2HH);
			BY2U6QnW.commit();
		} catch (SQLException ehAPQH20) {
			try {
				BY2U6QnW.rollback();
			} catch (Exception wRqM8sNm) {
			}
			String CqJmeZ67 = "SQLException in deleteProjectDeploymentConfig";
			log.error(CqJmeZ67, ehAPQH20);
			throw new AdaptationException(CqJmeZ67, ehAPQH20);
		} finally {
			try {
				DQcjlLQO.close();
			} catch (Exception eIBgt7gR) {
			}
			try {
				XHqop47W.close();
			} catch (Exception HJK1TGpk) {
			}
			try {
				BY2U6QnW.close();
			} catch (Exception ZBZ1gKLX) {
			}
		}
		return gdXYI2ez;
	}

}