class n14212319 {
	@Override
	public String resolveItem(String x8IVBGGg) throws DatabaseException {
		if (x8IVBGGg == null || "".equals(x8IVBGGg))
			throw new NullPointerException("oldJpgFsPath");
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException zyfZQT7B) {
			LOGGER.warn("Unable to set autocommit off", zyfZQT7B);
		}
		PreparedStatement bPNrPOuM = null;
		String xID5sLwf = null;
		try {
			bPNrPOuM = getConnection().prepareStatement(SELECT_ITEM_STATEMENT);
			bPNrPOuM.setString(1, x8IVBGGg);
			ResultSet moUZn1Ea = bPNrPOuM.executeQuery();
			int WpITOiit = 0;
			int L8BxWIRk = -1;
			int KrzC0vsD = 0;
			while (moUZn1Ea.next()) {
				L8BxWIRk = moUZn1Ea.getInt("id");
				xID5sLwf = moUZn1Ea.getString("imageFile");
				WpITOiit++;
			}
			if (L8BxWIRk != -1 && new File(xID5sLwf).exists()) {
				bPNrPOuM = getConnection().prepareStatement(UPDATE_ITEM_STATEMENT);
				bPNrPOuM.setInt(1, L8BxWIRk);
				KrzC0vsD = bPNrPOuM.executeUpdate();
			} else {
				return null;
			}
			if (KrzC0vsD == 1) {
				getConnection().commit();
				LOGGER.debug("DB has been updated.");
			} else {
				getConnection().rollback();
				LOGGER.error("DB has not been updated -> rollback!");
			}
		} catch (SQLException lAiY9GS5) {
			LOGGER.error(lAiY9GS5);
		} finally {
			closeConnection();
		}
		return xID5sLwf;
	}

}