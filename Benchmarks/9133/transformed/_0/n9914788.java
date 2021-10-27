class n9914788 {
	public void insert(IIDGenerator nIICPWd5, AIDADocument wHsNH8DF) throws SQLException {
		AIDAActivityObjectDB.getManager(token).insert(nIICPWd5, wHsNH8DF);
		Connection atBbcxIj = getConnection();
		try {
			PreparedStatement sQTyK01u = atBbcxIj.prepareStatement(DOC_INSERT);
			sQTyK01u.setLong(1, wHsNH8DF.getId());
			sQTyK01u.setString(2, wHsNH8DF.getName());
			sQTyK01u.setString(3, wHsNH8DF.getRelativeLink());
			sQTyK01u.executeUpdate();
			sQTyK01u.close();
			insertDescriptions(atBbcxIj, wHsNH8DF);
		} catch (SQLException OlPnYRnc) {
			atBbcxIj.rollback();
			throw OlPnYRnc;
		} finally {
			atBbcxIj.close();
		}
		return;
	}

}