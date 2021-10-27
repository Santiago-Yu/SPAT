class n20169230 {
	@Override
	public String addUserIdentity(OpenIDItem YafDVlTs, long mf8ja1sv) throws DatabaseException {
		if (YafDVlTs == null)
			throw new NullPointerException("identity");
		if (YafDVlTs.getIdentity() == null || "".equals(YafDVlTs.getIdentity()))
			throw new NullPointerException("identity.getIdentity()");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException Ctw54ewa) {
			LOGGER.warn("Unable to set autocommit off", Ctw54ewa);
		}
		String xGHwhR5h = "exist";
		PreparedStatement VuRq7otm = null, Giyy2LLn = null;
		try {
			int k48SM9di = 0;
			VuRq7otm = getConnection().prepareStatement(INSERT_IDENTITY_STATEMENT);
			VuRq7otm.setLong(1, mf8ja1sv);
			VuRq7otm.setString(2, YafDVlTs.getIdentity());
			k48SM9di = VuRq7otm.executeUpdate();
			Giyy2LLn = getConnection().prepareStatement(USER_IDENTITY_VALUE);
			ResultSet WcXFTj7b = Giyy2LLn.executeQuery();
			while (WcXFTj7b.next()) {
				xGHwhR5h = WcXFTj7b.getString(1);
			}
			if (k48SM9di == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Queries: \"" + Giyy2LLn + "\" and \"" + VuRq7otm + "\"");
			} else {
				getConnection().rollback();
				LOGGER.debug(
						"DB has not been updated -> rollback! Queries: \"" + Giyy2LLn + "\" and \"" + VuRq7otm + "\"");
				xGHwhR5h = "error";
			}
		} catch (SQLException iVl7VSM8) {
			LOGGER.error(iVl7VSM8);
			xGHwhR5h = "error";
		} finally {
			closeConnection();
		}
		return xGHwhR5h;
	}

}