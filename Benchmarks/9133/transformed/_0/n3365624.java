class n3365624 {
	private void updateService(int VWQVugR8, String kVyUePpa, int rZ1H0yrL, String jKzJpxcW) throws ServletException {
		Connection kFQojJFt = null;
		final DBUtils jUXdN6bo = new DBUtils(getClass());
		try {
			kFQojJFt = Vault.getDbConnection();
			jUXdN6bo.watch(kFQojJFt);
			PreparedStatement JiFoNAY0 = kFQojJFt.prepareStatement(UPDATE_SERVICE);
			jUXdN6bo.watch(JiFoNAY0);
			JiFoNAY0.setString(1, jKzJpxcW);
			JiFoNAY0.setInt(2, VWQVugR8);
			JiFoNAY0.setString(3, kVyUePpa);
			JiFoNAY0.setInt(4, rZ1H0yrL);
			JiFoNAY0.executeUpdate();
		} catch (SQLException OqqbKHe3) {
			try {
				kFQojJFt.rollback();
			} catch (SQLException ugN821FR) {
				throw new ServletException("Couldn't roll back update to service " + rZ1H0yrL + " on interface "
						+ kVyUePpa + " notify as " + jKzJpxcW + " in the database.", ugN821FR);
			}
			throw new ServletException("Error when updating to service " + rZ1H0yrL + " on interface " + kVyUePpa
					+ " notify as " + jKzJpxcW + " in the database.", OqqbKHe3);
		} finally {
			jUXdN6bo.cleanUp();
		}
	}

}