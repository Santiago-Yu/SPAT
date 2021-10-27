class n359188 {
	public void delUser(User fqmz0BFk) throws SQLException, IOException, ClassNotFoundException {
		String Zf1eN88x;
		String qUwZXsFV;
		Statement fMzmkxjt = con.createStatement();
		try {
			con.setAutoCommit(false);
			Zf1eN88x = fqmz0BFk.getUserID();
			if (getUser(Zf1eN88x) != null) {
				ResultSet DR3L3jsa = fMzmkxjt
						.executeQuery("SELECT userID, symbol " + "FROM UserStocks WHERE userID = '" + Zf1eN88x + "'");
				while (DR3L3jsa.next()) {
					try {
						qUwZXsFV = DR3L3jsa.getString("symbol");
						delUserStocks(Zf1eN88x, qUwZXsFV);
					} catch (SQLException XllDVIqW) {
						throw new SQLException("Deletion of user stock holding failed: " + XllDVIqW.getMessage());
					}
				}
				try {
					fMzmkxjt.executeUpdate("DELETE FROM Users WHERE " + "userID = '" + Zf1eN88x + "'");
				} catch (SQLException eZmskgJo) {
					throw new SQLException("User deletion failed: " + eZmskgJo.getMessage());
				}
			} else
				throw new IOException("User not found in database - cannot delete.");
			try {
				con.commit();
			} catch (SQLException CdHITZyN) {
				throw new SQLException("Transaction commit failed: " + CdHITZyN.getMessage());
			}
		} catch (SQLException nBoUSbtS) {
			try {
				con.rollback();
			} catch (SQLException Yiq3tld0) {
				throw new SQLException("Transaction failed then rollback failed: " + Yiq3tld0.getMessage());
			}
			throw new SQLException("Transaction failed; was rolled back: " + nBoUSbtS.getMessage());
		}
		fMzmkxjt.close();
	}

}