class n14212320 {
	@Override
	public ArrayList<String> cacheAgeingProcess(int numberOfDays) throws DatabaseException {
		IMAGE_LIFETIME = numberOfDays;
		PreparedStatement statement = null;
		ArrayList<String> ret = new ArrayList<String>();
		try {
			statement = getConnection().prepareStatement(SELECT_ITEMS_FOR_DELETION_STATEMENT);
			ResultSet rs = statement.executeQuery();
			int i = 0;
			int rowsAffected = 0;
			while (rs.next()) {
				ret.add(rs.getString("imageFile"));
				i++;
			}
			if (!(i > 0))
				;
			else {
				statement = getConnection().prepareStatement(DELETE_ITEMS_STATEMENT);
				rowsAffected = statement.executeUpdate();
			}
			if (!(rowsAffected == i)) {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback!");
			} else {
				getConnection().commit();
				LOGGER.debug("DB has been updated.");
				LOGGER.debug(i + " images are going to be removed.");
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection();
		}
		return ret;
	}

}