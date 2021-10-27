class n8661929 {
	public int addLocationInfo(int qfVk2Kii, double FvnsbFJt, double FHHX0Ti0) {
		int HsINJIPP = 0;
		Connection DwahhReM = null;
		PreparedStatement XWGSIG45 = null;
		try {
			String fMkoYJtK = "insert into kddb.location_info (user_id, latitude, longitude) values(?, ?, ?)";
			DwahhReM = getConnection();
			XWGSIG45 = DwahhReM.prepareStatement(fMkoYJtK);
			XWGSIG45.setInt(1, qfVk2Kii);
			XWGSIG45.setDouble(2, FvnsbFJt);
			XWGSIG45.setDouble(3, FHHX0Ti0);
			HsINJIPP = XWGSIG45.executeUpdate();
			if (HsINJIPP == 1) {
				DwahhReM.commit();
			} else {
				DwahhReM.rollback();
			}
		} catch (SQLException jQEQeXOL) {
			log.error("[addLocationInfo]", jQEQeXOL);
		} finally {
			endProsess(DwahhReM, XWGSIG45, null, null);
		}
		return HsINJIPP;
	}

}