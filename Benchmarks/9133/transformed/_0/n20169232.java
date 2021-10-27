class n20169232 {
	@Override
	public RoleItem addUserRole(RoleItem z8sJdtnm, long XxMAueUL) throws DatabaseException {
		if (z8sJdtnm == null)
			throw new NullPointerException("role");
		if (z8sJdtnm.getName() == null || "".equals(z8sJdtnm.getName()))
			throw new NullPointerException("role.getName()");
		if (hasRole(z8sJdtnm.getName(), XxMAueUL)) {
			return new RoleItem(z8sJdtnm.getName(), "", "exist");
		}
		RoleItem vYqYJdQ7 = new RoleItem(z8sJdtnm.getName(), "", "exist");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException UUXdn5sb) {
			LOGGER.warn("Unable to set autocommit off", UUXdn5sb);
		}
		String rylxVMWO = "exist";
		String lMto5QrF = "";
		PreparedStatement mtkcY7Ol = null, sJ8b3DFm = null;
		try {
			int g2YZosTz = 0;
			PreparedStatement qSoxJNju = getConnection().prepareStatement(INSERT_USER_IN_ROLE_STATEMENT);
			qSoxJNju.setLong(1, XxMAueUL);
			qSoxJNju.setString(2, z8sJdtnm.getName());
			g2YZosTz = qSoxJNju.executeUpdate();
			mtkcY7Ol = getConnection().prepareStatement(USER_ROLE_VALUE);
			ResultSet KstuC5P9 = mtkcY7Ol.executeQuery();
			while (KstuC5P9.next()) {
				rylxVMWO = KstuC5P9.getString(1);
			}
			sJ8b3DFm = getConnection().prepareStatement(SELECT_ROLE_DESCRIPTION);
			sJ8b3DFm.setString(1, z8sJdtnm.getName());
			ResultSet Znl79VA6 = sJ8b3DFm.executeQuery();
			while (Znl79VA6.next()) {
				lMto5QrF = Znl79VA6.getString(1);
			}
			if (g2YZosTz == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Queries: \"" + mtkcY7Ol + "\" and \"" + sJ8b3DFm + "\"");
			} else {
				getConnection().rollback();
				LOGGER.error(
						"DB has not been updated -> rollback! Queries: \"" + mtkcY7Ol + "\" and \"" + sJ8b3DFm + "\"");
				rylxVMWO = "error";
			}
		} catch (SQLException GoyaXXGa) {
			LOGGER.error(GoyaXXGa);
			rylxVMWO = "error";
		} finally {
			closeConnection();
		}
		vYqYJdQ7.setId(rylxVMWO);
		vYqYJdQ7.setDescription(lMto5QrF);
		return vYqYJdQ7;
	}

}