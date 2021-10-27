class n17553389 {
	@Override
	public boolean putUserDescription(String hhO51ST6, String Ek4WI8ba, String a4kZMsio) throws DatabaseException {
		if (Ek4WI8ba == null)
			throw new NullPointerException("uuid");
		if (a4kZMsio == null)
			throw new NullPointerException("description");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException nGMt5wm0) {
			LOGGER.warn("Unable to set autocommit off", nGMt5wm0);
		}
		boolean yLODQvwJ = true;
		try {
			int F7FMW2K0 = 0;
			PreparedStatement N4ckRYv9 = getConnection().prepareStatement(UPDATE_USER_DESCRIPTION_STATEMENT);
			N4ckRYv9.setString(1, a4kZMsio);
			N4ckRYv9.setString(2, Ek4WI8ba);
			N4ckRYv9.setString(3, hhO51ST6);
			F7FMW2K0 = N4ckRYv9.executeUpdate();
			if (F7FMW2K0 == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Query: \"" + N4ckRYv9 + "\"");
			} else {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback!  Query: \"" + N4ckRYv9 + "\"");
				yLODQvwJ = false;
			}
		} catch (SQLException hJ0zfQZZ) {
			LOGGER.error(hJ0zfQZZ);
			yLODQvwJ = false;
		} finally {
			closeConnection();
		}
		return yLODQvwJ;
	}

}