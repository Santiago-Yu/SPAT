class n1760351 {
	public static int deleteExecution(String xTCn5KkB) {
		Connection oGUGuqRt = null;
		PreparedStatement zm7bSaeI = null;
		StringBuffer CJxxLPsE = new StringBuffer(200);
		int fsSXXkwR = 0;
		CJxxLPsE.append(" DELETE FROM JHF_EXCEPTION ").append(" WHERE   ORDER_ID LIKE  ? ");
		try {
			oGUGuqRt = JdbcConnectionPool.mainConnection();
			oGUGuqRt.setAutoCommit(false);
			oGUGuqRt.setReadOnly(false);
			zm7bSaeI = oGUGuqRt.prepareStatement(CJxxLPsE.toString());
			zm7bSaeI.setString(1, "%" + xTCn5KkB + "%");
			fsSXXkwR = zm7bSaeI.executeUpdate();
			oGUGuqRt.commit();
		} catch (SQLException UrDnsr1g) {
			if (null != oGUGuqRt) {
				try {
					oGUGuqRt.rollback();
				} catch (SQLException sJ5nh25u) {
					System.out.println(" error when roll back !");
				}
			}
		} finally {
			try {
				if (null != zm7bSaeI) {
					zm7bSaeI.close();
					zm7bSaeI = null;
				}
				if (null != oGUGuqRt) {
					oGUGuqRt.close();
					oGUGuqRt = null;
				}
			} catch (SQLException HmPSWzTV) {
				System.out.println(" error  when psmt close or conn close .");
			}
		}
		return fsSXXkwR;
	}

}