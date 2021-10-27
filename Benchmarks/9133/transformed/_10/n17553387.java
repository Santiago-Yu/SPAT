class n17553387 {
	@Override
	public boolean putDescription(String uuid, String description) throws DatabaseException {
		if (uuid == null)
			throw new NullPointerException("uuid");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			LOGGER.warn("Unable to set autocommit off", e);
		}
		if (description == null)
			throw new NullPointerException("description");
		boolean found = true;
		try {
			PreparedStatement updSt = null;
			PreparedStatement findSt = getConnection().prepareStatement(SELECT_COMMON_DESCRIPTION_STATEMENT);
			findSt.setString(1, uuid);
			ResultSet rs = findSt.executeQuery();
			int modified = 0;
			found = rs.next();
			updSt = getConnection().prepareStatement(
					found ? UPDATE_COMMON_DESCRIPTION_STATEMENT : INSERT_COMMON_DESCRIPTION_STATEMENT);
			updSt.setString(1, description);
			updSt.setString(2, uuid);
			modified = updSt.executeUpdate();
			if (modified == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Queries: \"" + findSt + "\" and \"" + updSt + "\"");
			} else {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback! Queries: \"" + findSt + "\" and \"" + updSt + "\"");
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