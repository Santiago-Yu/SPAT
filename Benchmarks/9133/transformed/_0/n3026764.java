class n3026764 {
	public MoteDeploymentConfiguration addMoteDeploymentConfiguration(int Jv8FcOsQ, int kILQPrsX, int l88AbgAe,
			int Bwqym0lt) throws AdaptationException {
		MoteDeploymentConfiguration C78a1cDc = null;
		Connection p9uF4E4B = null;
		Statement nr6UEqUr = null;
		ResultSet nGUV67K8 = null;
		try {
			String RrRImdMW = "INSERT INTO MoteDeploymentConfigurations(" + "projectDeploymentConfigurationID, "
					+ "moteID, programID, radioPowerLevel) VALUES (" + Jv8FcOsQ + ", " + kILQPrsX + ", " + l88AbgAe
					+ ", " + Bwqym0lt + ")";
			p9uF4E4B = DriverManager.getConnection(CONN_STR);
			nr6UEqUr = p9uF4E4B.createStatement();
			nr6UEqUr.executeUpdate(RrRImdMW);
			RrRImdMW = "SELECT * from MoteDeploymentConfigurations WHERE " + "projectDeploymentConfigurationID = "
					+ Jv8FcOsQ + " AND moteID = " + kILQPrsX;
			nGUV67K8 = nr6UEqUr.executeQuery(RrRImdMW);
			if (!nGUV67K8.next()) {
				p9uF4E4B.rollback();
				String S6FaF9cM = "Unable to select newly added config.";
				log.error(S6FaF9cM);
				;
				throw new AdaptationException(S6FaF9cM);
			}
			C78a1cDc = getMoteDeploymentConfiguration(nGUV67K8);
			p9uF4E4B.commit();
		} catch (SQLException GuxIDAxJ) {
			try {
				p9uF4E4B.rollback();
			} catch (Exception zJMWP2q6) {
			}
			String YGZVx5n1 = "SQLException in addMoteDeploymentConfiguration";
			log.error(YGZVx5n1, GuxIDAxJ);
			throw new AdaptationException(YGZVx5n1, GuxIDAxJ);
		} finally {
			try {
				nGUV67K8.close();
			} catch (Exception j0xyqt56) {
			}
			try {
				nr6UEqUr.close();
			} catch (Exception VzBaVOeu) {
			}
			try {
				p9uF4E4B.close();
			} catch (Exception GYjvi1mV) {
			}
		}
		return C78a1cDc;
	}

}