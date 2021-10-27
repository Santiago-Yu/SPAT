class n18942525 {
	public void updateUserInfo(AuthSession TAtGJJEz, AuthUserExtendedInfo K9Et1veB) {
		log.info("Start update auth");
		PreparedStatement VL1qniB2 = null;
		DatabaseAdapter OXlfQDeM = null;
		try {
			OXlfQDeM = DatabaseAdapter.getInstance();
			String iKPoU2Ob = "update WM_AUTH_USER " + "set " + "ID_FIRM=?, IS_USE_CURRENT_FIRM=?, "
					+ "ID_HOLDING=?, IS_HOLDING=? " + "WHERE  ID_AUTH_USER=? ";
			VL1qniB2 = OXlfQDeM.prepareStatement(iKPoU2Ob);
			if (K9Et1veB.getAuthInfo().getCompanyId() == null) {
				VL1qniB2.setNull(1, Types.INTEGER);
				VL1qniB2.setInt(2, 0);
			} else {
				VL1qniB2.setLong(1, K9Et1veB.getAuthInfo().getCompanyId());
				VL1qniB2.setInt(2, K9Et1veB.getAuthInfo().isCompany() ? 1 : 0);
			}
			if (K9Et1veB.getAuthInfo().getHoldingId() == null) {
				VL1qniB2.setNull(3, Types.INTEGER);
				VL1qniB2.setInt(4, 0);
			} else {
				VL1qniB2.setLong(3, K9Et1veB.getAuthInfo().getHoldingId());
				VL1qniB2.setInt(4, K9Et1veB.getAuthInfo().isHolding() ? 1 : 0);
			}
			VL1qniB2.setLong(5, K9Et1veB.getAuthInfo().getAuthUserId());
			VL1qniB2.executeUpdate();
			processDeletedRoles(OXlfQDeM, K9Et1veB);
			processNewRoles(OXlfQDeM, K9Et1veB.getRoles(), K9Et1veB.getAuthInfo().getAuthUserId());
			OXlfQDeM.commit();
		} catch (Throwable lQBSBwHF) {
			try {
				if (OXlfQDeM != null)
					OXlfQDeM.rollback();
			} catch (Exception qdoufNIV) {
			}
			final String XTZHIaHG = "Error add user auth";
			log.error(XTZHIaHG, lQBSBwHF);
			throw new IllegalStateException(XTZHIaHG, lQBSBwHF);
		} finally {
			DatabaseManager.close(OXlfQDeM, VL1qniB2);
			VL1qniB2 = null;
			OXlfQDeM = null;
			log.info("End update auth");
		}
	}

}