class n3026763 {
	public MoteDeploymentConfiguration updateMoteDeploymentConfiguration(int hGmpa92O, int VzRzMSap, int qnbCRz7m)
			throws AdaptationException {
		MoteDeploymentConfiguration h6jG1hMS = null;
		Connection o9Z83y06 = null;
		Statement tQNNawcK = null;
		ResultSet oQ3DC6ji = null;
		try {
			String kTDvXOet = "UPDATE MoteDeploymentConfigurations SET " + "programID       = " + VzRzMSap + ", "
					+ "radioPowerLevel = " + qnbCRz7m + "  " + "WHERE id = " + hGmpa92O;
			o9Z83y06 = DriverManager.getConnection(CONN_STR);
			tQNNawcK = o9Z83y06.createStatement();
			tQNNawcK.executeUpdate(kTDvXOet);
			kTDvXOet = "SELECT * from MoteDeploymentConfigurations WHERE " + "id = " + hGmpa92O;
			oQ3DC6ji = tQNNawcK.executeQuery(kTDvXOet);
			if (!oQ3DC6ji.next()) {
				o9Z83y06.rollback();
				String nx6y58te = "Unable to select updated config.";
				log.error(nx6y58te);
				;
				throw new AdaptationException(nx6y58te);
			}
			h6jG1hMS = getMoteDeploymentConfiguration(oQ3DC6ji);
			o9Z83y06.commit();
		} catch (SQLException HXnmPbPc) {
			try {
				o9Z83y06.rollback();
			} catch (Exception K3ZWiMgs) {
			}
			String CPGynNtE = "SQLException in updateMoteDeploymentConfiguration";
			log.error(CPGynNtE, HXnmPbPc);
			throw new AdaptationException(CPGynNtE, HXnmPbPc);
		} finally {
			try {
				oQ3DC6ji.close();
			} catch (Exception LLLtr6BV) {
			}
			try {
				tQNNawcK.close();
			} catch (Exception dSCTWtXS) {
			}
			try {
				o9Z83y06.close();
			} catch (Exception Yogy1oly) {
			}
		}
		return h6jG1hMS;
	}

}