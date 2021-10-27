class n23398987 {
	@Override
	public void updateItems(List<InputQueueItem> ZQz4A0qk) throws DatabaseException {
		if (ZQz4A0qk == null)
			throw new NullPointerException("toUpdate");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException Z0ho91na) {
			LOGGER.warn("Unable to set autocommit off", Z0ho91na);
		}
		try {
			PreparedStatement fbxTwVG0 = getConnection().prepareStatement(DELETE_ALL_ITEMS_STATEMENT);
			PreparedStatement NAFmXqxE = getConnection().prepareStatement(SELECT_NUMBER_ITEMS_STATEMENT);
			ResultSet lb8jd2k5 = NAFmXqxE.executeQuery();
			lb8jd2k5.next();
			int jWO0P42k = lb8jd2k5.getInt(1);
			int Xv12kk0X = fbxTwVG0.executeUpdate();
			int wdFdIzbS = 0;
			for (InputQueueItem fMUP0MQF : ZQz4A0qk) {
				wdFdIzbS += getItemInsertStatement(fMUP0MQF).executeUpdate();
			}
			if (jWO0P42k == Xv12kk0X && wdFdIzbS == ZQz4A0qk.size()) {
				getConnection().commit();
				LOGGER.debug("DB has been updated. Queries: \"" + NAFmXqxE + "\" and \"" + fbxTwVG0 + "\".");
			} else {
				getConnection().rollback();
				LOGGER.error(
						"DB has not been updated -> rollback! Queries: \"" + NAFmXqxE + "\" and \"" + fbxTwVG0 + "\".");
			}
		} catch (SQLException J0JIhQja) {
			LOGGER.error(J0JIhQja);
		} finally {
			closeConnection();
		}
	}

}