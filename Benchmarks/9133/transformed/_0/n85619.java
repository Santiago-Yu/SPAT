class n85619 {
	public void delUser(User AIM2ItUx) throws SQLException, IOException, ClassNotFoundException {
		String lKjJdXb2;
		String WbEvcjDf;
		Statement U8w07MHh = con.createStatement();
		try {
			con.setAutoCommit(false);
			lKjJdXb2 = AIM2ItUx.getUserID();
			if (getUser(lKjJdXb2) != null) {
				ResultSet w3NZr6zr = U8w07MHh
						.executeQuery("SELECT userID, symbol " + "FROM UserStocks WHERE userID = '" + lKjJdXb2 + "'");
				while (w3NZr6zr.next()) {
					try {
						WbEvcjDf = w3NZr6zr.getString("symbol");
						delUserStocks(lKjJdXb2, WbEvcjDf);
					} catch (SQLException frMytcL6) {
						throw new SQLException("Deletion of user stock holding failed: " + frMytcL6.getMessage());
					}
				}
				try {
					U8w07MHh.executeUpdate("DELETE FROM Users WHERE " + "userID = '" + lKjJdXb2 + "'");
				} catch (SQLException F5hR2z2B) {
					throw new SQLException("User deletion failed: " + F5hR2z2B.getMessage());
				}
			} else
				throw new IOException("User not found in database - cannot delete.");
			try {
				con.commit();
			} catch (SQLException DuTM3PeS) {
				throw new SQLException("Transaction commit failed: " + DuTM3PeS.getMessage());
			}
		} catch (SQLException HNkFJaU1) {
			try {
				con.rollback();
			} catch (SQLException ws0OQ6rr) {
				throw new SQLException("Transaction failed then rollback failed: " + ws0OQ6rr.getMessage());
			}
			throw new SQLException("Transaction failed; was rolled back: " + HNkFJaU1.getMessage());
		}
		U8w07MHh.close();
	}

}