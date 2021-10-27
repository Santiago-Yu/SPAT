class n23531898 {
	public void doUpdateByLoginID() throws Exception {
		if (!isValidate()) {
			throw new CesSystemException("User_session.doUpdateByLoginID(): Illegal data values for update");
		}
		Connection JHqskOio = null;
		PreparedStatement UWsK0vtQ = null;
		String ynk1YrNN = "UPDATE " + Common.USER_SESSION_TABLE + " SET "
				+ "session_id = ?, user_id = ?, begin_date = ? , " + "ip_address = ?, mac_no = ? "
				+ "WHERE  login_id= ?";
		DBOperation gBI2sA5P = factory.createDBOperation(POOL_NAME);
		try {
			JHqskOio = gBI2sA5P.getConnection();
			JHqskOio.setAutoCommit(false);
			UWsK0vtQ = JHqskOio.prepareStatement(ynk1YrNN);
			UWsK0vtQ.setString(1, this.sessionID);
			UWsK0vtQ.setInt(2, this.user.getUserID());
			UWsK0vtQ.setTimestamp(3, this.beginDate);
			UWsK0vtQ.setString(4, this.ipAddress);
			UWsK0vtQ.setString(5, this.macNO);
			UWsK0vtQ.setString(6, this.loginID);
			int NTGHFSqp = UWsK0vtQ.executeUpdate();
			if (NTGHFSqp != 1) {
				JHqskOio.rollback();
				throw new CesSystemException(
						"User_session.doUpdateByLoginID(): ERROR updating data in T_SYS_USER_SESSION!! "
								+ "resultCount = " + NTGHFSqp);
			}
			JHqskOio.commit();
		} catch (SQLException pZHwPW8r) {
			if (JHqskOio != null) {
				JHqskOio.rollback();
			}
			throw new CesSystemException("User_session.doUpdateByLoginID(): SQLException while updating user_session; "
					+ "session_id = " + this.sessionID + " :\n\t" + pZHwPW8r);
		} finally {
			JHqskOio.setAutoCommit(true);
			closePreparedStatement(UWsK0vtQ);
			closeConnection(gBI2sA5P);
		}
	}

}