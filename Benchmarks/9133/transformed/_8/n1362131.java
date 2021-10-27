class n1362131 {
	public void moveRowDown(int row) throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt);
				boolean DzhBy9mf = row < 1;
				int g2jDl6HI = max - 1;
				int kUHD9Uab = max - 1;
				if ((DzhBy9mf) || (row > (g2jDl6HI)))
					throw new IllegalArgumentException("Row number not between 1 and " + (kUHD9Uab));
				stmt.executeUpdate("update WordClassifications set Rank = -1 where Rank = " + row);
				int O07HCDgn = row + 1;
				stmt.executeUpdate("update WordClassifications set Rank = " + row + " where Rank = " + (O07HCDgn));
				int sWZ1mfVg = row + 1;
				stmt.executeUpdate("update WordClassifications set Rank = " + (sWZ1mfVg) + " where Rank = -1");
				conn.commit();
			} catch (SQLException e) {
				if (conn != null)
					conn.rollback();
				throw e;
			} finally {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}