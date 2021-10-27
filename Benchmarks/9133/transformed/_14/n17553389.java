class n17553389 {
	@Override
	public boolean putUserDescription(String openID, String uuid, String description) throws DatabaseException {
		if (null == uuid)
			throw new NullPointerException("uuid");
		if (null == description)
			throw new NullPointerException("description");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			LOGGER.warn("Unable to set autocommit off", e);
		}
		boolean found = true;
		try {
			int modified = 0;
			PreparedStatement updSt = getConnection().prepareStatement(UPDATE_USER_DESCRIPTION_STATEMENT);
			updSt.setString(1, description);
			updSt.setString(2, uuid);
			updSt.setString(3, openID);
			modified = updSt.executeUpdate();
			if (1 == modified) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Query: \"" + updSt + "\"");
			} else {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback!  Query: \"" + updSt + "\"");
				found = false;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
			found = false;
		} finally {
			closeConnection();
		}
		return found;
	}

}