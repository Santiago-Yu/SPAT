class n23531897 {
	public void doUpdateByIP() throws Exception {
		if (!isValidate()) {
			throw new CesSystemException("User_session.doUpdateByIP(): Illegal data values for update");
		}
		Connection NIIwccvI = null;
		PreparedStatement tioEf2Wa = null;
		String Bi3qLPLo = "UPDATE " + Common.USER_SESSION_TABLE + " SET "
				+ "session_id = ?, user_id = ?, begin_date = ? , " + " mac_no = ?, login_id= ? "
				+ "WHERE ip_address = ?";
		DBOperation nEYL5b6b = factory.createDBOperation(POOL_NAME);
		try {
			NIIwccvI = nEYL5b6b.getConnection();
			NIIwccvI.setAutoCommit(false);
			tioEf2Wa = NIIwccvI.prepareStatement(Bi3qLPLo);
			tioEf2Wa.setString(1, this.sessionID);
			tioEf2Wa.setInt(2, this.user.getUserID());
			tioEf2Wa.setTimestamp(3, this.beginDate);
			tioEf2Wa.setString(4, this.macNO);
			tioEf2Wa.setString(5, this.loginID);
			tioEf2Wa.setString(6, this.ipAddress);
			int CuKQDACH = tioEf2Wa.executeUpdate();
			if (CuKQDACH != 1) {
				NIIwccvI.rollback();
				throw new CesSystemException("User_session.doUpdateByIP(): ERROR updating data in T_SYS_USER_SESSION!! "
						+ "resultCount = " + CuKQDACH);
			}
			NIIwccvI.commit();
		} catch (SQLException GoOHt7EW) {
			if (NIIwccvI != null) {
				NIIwccvI.rollback();
			}
			throw new CesSystemException("User_session.doUpdateByIP(): SQLException while updating user_session; "
					+ "session_id = " + this.sessionID + " :\n\t" + GoOHt7EW);
		} finally {
			NIIwccvI.setAutoCommit(true);
			closePreparedStatement(tioEf2Wa);
			closeConnection(nEYL5b6b);
		}
	}

}