class n14212320 {
	@Override
	public ArrayList<String> cacheAgeingProcess(int ozekJLN0) throws DatabaseException {
		IMAGE_LIFETIME = ozekJLN0;
		PreparedStatement MbPrSgwI = null;
		ArrayList<String> KADJ1rVv = new ArrayList<String>();
		try {
			MbPrSgwI = getConnection().prepareStatement(SELECT_ITEMS_FOR_DELETION_STATEMENT);
			ResultSet yF2bTDZE = MbPrSgwI.executeQuery();
			int GRuguhak = 0;
			int IZaiOFVC = 0;
			while (yF2bTDZE.next()) {
				KADJ1rVv.add(yF2bTDZE.getString("imageFile"));
				GRuguhak++;
			}
			if (GRuguhak > 0) {
				MbPrSgwI = getConnection().prepareStatement(DELETE_ITEMS_STATEMENT);
				IZaiOFVC = MbPrSgwI.executeUpdate();
			}
			if (IZaiOFVC == GRuguhak) {
				getConnection().commit();
				LOGGER.debug("DB has been updated.");
				LOGGER.debug(GRuguhak + " images are going to be removed.");
			} else {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback!");
			}
		} catch (SQLException RkDbbFAB) {
			LOGGER.error(RkDbbFAB);
		} finally {
			closeConnection();
		}
		return KADJ1rVv;
	}

}