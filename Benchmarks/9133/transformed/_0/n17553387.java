class n17553387 {
	@Override
	public boolean putDescription(String DOwKvhAV, String DuHEFomL) throws DatabaseException {
		if (DOwKvhAV == null)
			throw new NullPointerException("uuid");
		if (DuHEFomL == null)
			throw new NullPointerException("description");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException xQCfmUfd) {
			LOGGER.warn("Unable to set autocommit off", xQCfmUfd);
		}
		boolean AfyW5OE4 = true;
		try {
			PreparedStatement vZhjvkR7 = getConnection().prepareStatement(SELECT_COMMON_DESCRIPTION_STATEMENT);
			PreparedStatement BHuffOBK = null;
			vZhjvkR7.setString(1, DOwKvhAV);
			ResultSet TI9ff9rA = vZhjvkR7.executeQuery();
			AfyW5OE4 = TI9ff9rA.next();
			int hfXE5NVE = 0;
			BHuffOBK = getConnection().prepareStatement(
					AfyW5OE4 ? UPDATE_COMMON_DESCRIPTION_STATEMENT : INSERT_COMMON_DESCRIPTION_STATEMENT);
			BHuffOBK.setString(1, DuHEFomL);
			BHuffOBK.setString(2, DOwKvhAV);
			hfXE5NVE = BHuffOBK.executeUpdate();
			if (hfXE5NVE == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Queries: \"" + vZhjvkR7 + "\" and \"" + BHuffOBK + "\"");
			} else {
				getConnection().rollback();
				LOGGER.error(
						"DB has not been updated -> rollback! Queries: \"" + vZhjvkR7 + "\" and \"" + BHuffOBK + "\"");
				AfyW5OE4 = false;
			}
		} catch (SQLException pnRK0M7F) {
			LOGGER.error(pnRK0M7F);
			AfyW5OE4 = false;
		} finally {
			closeConnection();
		}
		return AfyW5OE4;
	}

}