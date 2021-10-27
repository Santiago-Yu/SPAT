class n716706 {
	public void delUser(User qrTcyJUO) throws SQLException, IOException, ClassNotFoundException {
		String dwMWI9uk;
		String oEPZtVTf;
		Statement mKaGVxRS = con.createStatement();
		try {
			con.setAutoCommit(false);
			dwMWI9uk = qrTcyJUO.getUserID();
			if (getUser(dwMWI9uk) != null) {
				ResultSet DGLJROnQ = mKaGVxRS
						.executeQuery("SELECT userID, symbol " + "FROM UserStocks WHERE userID = '" + dwMWI9uk + "'");
				while (DGLJROnQ.next()) {
					try {
						oEPZtVTf = DGLJROnQ.getString("symbol");
						delUserStocks(dwMWI9uk, oEPZtVTf);
					} catch (SQLException k8x9ic0i) {
						throw new SQLException("Deletion of user stock holding failed: " + k8x9ic0i.getMessage());
					}
				}
				try {
					mKaGVxRS.executeUpdate("DELETE FROM Users WHERE " + "userID = '" + dwMWI9uk + "'");
				} catch (SQLException YgF5BIde) {
					throw new SQLException("User deletion failed: " + YgF5BIde.getMessage());
				}
			} else
				throw new IOException("User not found in database - cannot delete.");
			try {
				con.commit();
			} catch (SQLException YGthxyvB) {
				throw new SQLException("Transaction commit failed: " + YGthxyvB.getMessage());
			}
		} catch (SQLException BkbRh84B) {
			try {
				con.rollback();
			} catch (SQLException OUHGnEHw) {
				throw new SQLException("Transaction failed then rollback failed: " + OUHGnEHw.getMessage());
			}
			throw new SQLException("Transaction failed; was rolled back: " + BkbRh84B.getMessage());
		}
		mKaGVxRS.close();
	}

}