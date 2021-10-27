class n14212320 {
	@Override
	public ArrayList<String> cacheAgeingProcess(int numberOfDays) throws DatabaseException {
		PreparedStatement statement = null;
		IMAGE_LIFETIME = numberOfDays;
		ArrayList<String> ret = new ArrayList<String>();
		try {
			statement = getConnection().prepareStatement(SELECT_ITEMS_FOR_DELETION_STATEMENT);
			int i = 0;
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ret.add(rs.getString("imageFile"));
				i++;
			}
			int rowsAffected = 0;
			if (i > 0) {
				statement = getConnection().prepareStatement(DELETE_ITEMS_STATEMENT);
				rowsAffected = statement.executeUpdate();
			}
			if (rowsAffected == i) {
				getConnection().commit();
				LOGGER.debug("DB has been updated.");
				LOGGER.debug(i + " images are going to be removed.");
			} else {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback!");
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection();
		}
		return ret;
	}

}