class n21817955 {
	public void movePrior(String[] LrraUvYL, String[] cv5WpUO4, String zXysHXjc, String rt8JVzyu) throws Exception {
		Connection DOi8bPqo = null;
		PreparedStatement CMwd1IGD = null;
		ResultSet MfIFOI35 = null;
		int xUJjpP4c = LrraUvYL.length;
		DBOperation oSzX5Yef = factory.createDBOperation(POOL_NAME);
		String bqs7fOQ5 = "select show_order from " + Common.ORGANIZE_TABLE + " where show_order="
				+ LrraUvYL[xUJjpP4c - 1] + " and organize_id= '" + cv5WpUO4[xUJjpP4c - 1] + "'";
		try {
			DOi8bPqo = oSzX5Yef.getConnection();
			DOi8bPqo.setAutoCommit(false);
			CMwd1IGD = DOi8bPqo.prepareStatement(bqs7fOQ5);
			MfIFOI35 = CMwd1IGD.executeQuery();
			int fAFcGlaM = 0;
			if (MfIFOI35.next()) {
				fAFcGlaM = MfIFOI35.getInt(1);
			}
			String[] ZCsfLYUo = new String[xUJjpP4c + 1];
			ZCsfLYUo[0] = "update " + Common.ORGANIZE_TABLE + " set show_order=" + fAFcGlaM + " where show_order="
					+ zXysHXjc + " and organize_id= '" + rt8JVzyu + "'";
			for (int qBM3hlJ3 = 0; qBM3hlJ3 < LrraUvYL.length; qBM3hlJ3++) {
				ZCsfLYUo[qBM3hlJ3 + 1] = "update " + Common.ORGANIZE_TABLE + " set show_order=show_order-1"
						+ " where show_order=" + LrraUvYL[qBM3hlJ3] + " and organize_id= '" + cv5WpUO4[qBM3hlJ3] + "'";
			}
			for (int E1NLE8fv = 0; E1NLE8fv < ZCsfLYUo.length; E1NLE8fv++) {
				CMwd1IGD = DOi8bPqo.prepareStatement(ZCsfLYUo[E1NLE8fv]);
				int usl1d1Rb = CMwd1IGD.executeUpdate();
				if (usl1d1Rb != 1) {
					throw new CesSystemException("Organize.movePrior(): ERROR Inserting data "
							+ "in T_SYS_ORGANIZE update !! resultCount = " + usl1d1Rb);
				}
			}
			DOi8bPqo.commit();
		} catch (SQLException L1aZTAWH) {
			if (DOi8bPqo != null) {
				DOi8bPqo.rollback();
			}
			throw new CesSystemException(
					"Organize.movePrior(): SQLException while mov organize order " + " :\n\t" + L1aZTAWH);
		} finally {
			DOi8bPqo.setAutoCommit(true);
			close(oSzX5Yef, CMwd1IGD, MfIFOI35);
		}
	}

}