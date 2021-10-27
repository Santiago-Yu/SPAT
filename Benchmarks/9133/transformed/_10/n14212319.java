class n14212319 {
	@Override
	public String resolveItem(String oldJpgFsPath) throws DatabaseException {
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			LOGGER.warn("Unable to set autocommit off", e);
		}
		if (oldJpgFsPath == null || "".equals(oldJpgFsPath))
			throw new NullPointerException("oldJpgFsPath");
		String ret = null;
		PreparedStatement statement = null;
		try {
			statement = getConnection().prepareStatement(SELECT_ITEM_STATEMENT);
			statement.setString(1, oldJpgFsPath);
			int i = 0;
			ResultSet rs = statement.executeQuery();
			int rowsAffected = 0;
			int id = -1;
			while (rs.next()) {
				id = rs.getInt("id");
				i++;
				ret = rs.getString("imageFile");
			}
			if (id != -1 && new File(ret).exists()) {
				statement = getConnection().prepareStatement(UPDATE_ITEM_STATEMENT);
				statement.setInt(1, id);
				rowsAffected = statement.executeUpdate();
			} else {
				return null;
			}
			if (rowsAffected == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated.");
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