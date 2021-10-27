class n20169227 {
	@Override
	public String addUser(UserInfoItem FFAApCUS) throws DatabaseException {
		if (FFAApCUS == null)
			throw new NullPointerException("user");
		if (FFAApCUS.getSurname() == null || "".equals(FFAApCUS.getSurname()))
			throw new NullPointerException("user.getSurname()");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException uuIeCSTd) {
			LOGGER.warn("Unable to set autocommit off", uuIeCSTd);
		}
		String RfSkKlCV = "exist";
		PreparedStatement oIXPZbtO = null, g2LoIHk4 = null, ODCXJzdn = null;
		try {
			int LMuw9IRg = 0;
			if (FFAApCUS.getId() != null) {
				long Z5BSYU5p = Long.parseLong(FFAApCUS.getId());
				g2LoIHk4 = getConnection().prepareStatement(UPDATE_USER_STATEMENT);
				g2LoIHk4.setString(1, FFAApCUS.getName());
				g2LoIHk4.setString(2, FFAApCUS.getSurname());
				g2LoIHk4.setLong(3, Z5BSYU5p);
				LMuw9IRg = g2LoIHk4.executeUpdate();
			} else {
				oIXPZbtO = getConnection().prepareStatement(INSERT_USER_STATEMENT);
				oIXPZbtO.setString(1, FFAApCUS.getName());
				oIXPZbtO.setString(2, FFAApCUS.getSurname());
				oIXPZbtO.setBoolean(3, "m".equalsIgnoreCase(FFAApCUS.getSex()));
				LMuw9IRg = oIXPZbtO.executeUpdate();
				ODCXJzdn = getConnection().prepareStatement(USER_CURR_VALUE);
				ResultSet Xvr3EL0n = ODCXJzdn.executeQuery();
				while (Xvr3EL0n.next()) {
					RfSkKlCV = Xvr3EL0n.getString(1);
				}
			}
			if (LMuw9IRg == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Queries: \"" + ODCXJzdn + "\" and \""
						+ (FFAApCUS.getId() != null ? g2LoIHk4 : oIXPZbtO) + "\"");
			} else {
				getConnection().rollback();
				LOGGER.debug("DB has not been updated. -> rollback! Queries: \"" + ODCXJzdn + "\" and \""
						+ (FFAApCUS.getId() != null ? g2LoIHk4 : oIXPZbtO) + "\"");
				RfSkKlCV = "error";
			}
		} catch (SQLException PvmiPZql) {
			LOGGER.error(PvmiPZql);
			RfSkKlCV = "error";
		} finally {
			closeConnection();
		}
		return RfSkKlCV;
	}

}