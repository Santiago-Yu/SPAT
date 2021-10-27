class n857860 {
	public void delUser(User tuTQIa0V) throws SQLException, IOException, ClassNotFoundException {
		String zFHJGaAo;
		String gORSJJbM;
		Statement Lhz1WEHd = con.createStatement();
		try {
			con.setAutoCommit(false);
			zFHJGaAo = tuTQIa0V.getUserID();
			if (getUser(zFHJGaAo) != null) {
				ResultSet JOtUIIFz = Lhz1WEHd
						.executeQuery("SELECT userID, symbol " + "FROM UserStocks WHERE userID = '" + zFHJGaAo + "'");
				while (JOtUIIFz.next()) {
					try {
						gORSJJbM = JOtUIIFz.getString("symbol");
						delUserStocks(zFHJGaAo, gORSJJbM);
					} catch (SQLException JzHZ9GBH) {
						throw new SQLException("Deletion of user stock holding failed: " + JzHZ9GBH.getMessage());
					}
				}
				try {
					Lhz1WEHd.executeUpdate("DELETE FROM Users WHERE " + "userID = '" + zFHJGaAo + "'");
				} catch (SQLException hnYqqV3y) {
					throw new SQLException("User deletion failed: " + hnYqqV3y.getMessage());
				}
			} else
				throw new IOException("User not found in database - cannot delete.");
			try {
				con.commit();
			} catch (SQLException Cp3LqQFE) {
				throw new SQLException("Transaction commit failed: " + Cp3LqQFE.getMessage());
			}
		} catch (SQLException mPsV7GFt) {
			try {
				con.rollback();
			} catch (SQLException ePbDmFeL) {
				throw new SQLException("Transaction failed then rollback failed: " + ePbDmFeL.getMessage());
			}
			throw new SQLException("Transaction failed; was rolled back: " + mPsV7GFt.getMessage());
		}
		Lhz1WEHd.close();
	}

}