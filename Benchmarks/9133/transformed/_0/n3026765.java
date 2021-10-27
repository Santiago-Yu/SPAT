class n3026765 {
	public MoteDeploymentConfiguration deleteMoteDeploymentConfiguration(int JwhnXBQk) throws AdaptationException {
		MoteDeploymentConfiguration J0gZx1Of = null;
		Connection t8jLwvif = null;
		Statement X6igm5M0 = null;
		ResultSet FX7znPOe = null;
		try {
			String NmGTYKCb = "SELECT * FROM MoteDeploymentConfigurations " + "WHERE id = " + JwhnXBQk;
			t8jLwvif = DriverManager.getConnection(CONN_STR);
			X6igm5M0 = t8jLwvif.createStatement();
			FX7znPOe = X6igm5M0.executeQuery(NmGTYKCb);
			if (!FX7znPOe.next()) {
				String dYxdO6sA = "Unable to select config to delete.";
				log.error(dYxdO6sA);
				throw new AdaptationException(dYxdO6sA);
			}
			J0gZx1Of = getMoteDeploymentConfiguration(FX7znPOe);
			NmGTYKCb = "DELETE FROM MoteDeploymentConfigurations " + "WHERE id = " + JwhnXBQk;
			X6igm5M0.executeUpdate(NmGTYKCb);
			t8jLwvif.commit();
		} catch (SQLException YT2qzPGM) {
			try {
				t8jLwvif.rollback();
			} catch (Exception VLXUEM6f) {
			}
			String odyuqCO6 = "SQLException in deleteMoteDeploymentConfiguration";
			log.error(odyuqCO6, YT2qzPGM);
			throw new AdaptationException(odyuqCO6, YT2qzPGM);
		} finally {
			try {
				FX7znPOe.close();
			} catch (Exception wDZUtB94) {
			}
			try {
				X6igm5M0.close();
			} catch (Exception rQ7BNDCm) {
			}
			try {
				t8jLwvif.close();
			} catch (Exception pWrBWS1r) {
			}
		}
		return J0gZx1Of;
	}

}