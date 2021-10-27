class n21438069 {
	public ProjectDeploymentConfiguration createNewProjectDeploymentConfig(int CRo3wpMV, String cuaGA70F,
			String b44clYyf) throws AdaptationException {
		ProjectDeploymentConfiguration GYVBTMLm = null;
		Connection JOECrHOZ = null;
		Statement RigGuCtn = null;
		ResultSet mdzuG7OZ = null;
		try {
			String beDYHwx8 = "INSERT INTO ProjectDeploymentConfigurations" + "(projectID, name, description) VALUES ("
					+ CRo3wpMV + ", '" + cuaGA70F + "', '" + b44clYyf + "')";
			JOECrHOZ = DriverManager.getConnection(CONN_STR);
			RigGuCtn = JOECrHOZ.createStatement();
			RigGuCtn.executeUpdate(beDYHwx8);
			beDYHwx8 = "SELECT * FROM ProjectDeploymentConfigurations WHERE " + " projectID   = " + CRo3wpMV + "  AND "
					+ " name        = '" + cuaGA70F + "' AND " + " description = '" + b44clYyf + "'";
			mdzuG7OZ = RigGuCtn.executeQuery(beDYHwx8);
			if (!mdzuG7OZ.next()) {
				JOECrHOZ.rollback();
				String PMFHyAXs = "Attempt to create " + "ProjectDeploymentConfiguration failed.";
				log.error(PMFHyAXs);
				throw new AdaptationException(PMFHyAXs);
			}
			GYVBTMLm = getProjectDeploymentConfiguration(mdzuG7OZ);
			JOECrHOZ.commit();
		} catch (SQLException QKokttGs) {
			try {
				JOECrHOZ.rollback();
			} catch (Exception loxUV3Mq) {
			}
			String F4PAKfLs = "SQLException in createNewProjectDeploymentConfig";
			log.error(F4PAKfLs, QKokttGs);
			throw new AdaptationException(F4PAKfLs, QKokttGs);
		} finally {
			try {
				mdzuG7OZ.close();
			} catch (Exception WrXJnCa7) {
			}
			try {
				RigGuCtn.close();
			} catch (Exception MWgP6Gkd) {
			}
			try {
				JOECrHOZ.close();
			} catch (Exception Q3YHw5Qi) {
			}
		}
		return GYVBTMLm;
	}

}