class n1362130 {
	public void moveRowUp(int row) throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt);
				if ((row < 2) || (row > max))
					throw new IllegalArgumentException("Row number not between 2 and " + max);
				stmt.executeUpdate("update WordClassifications set Rank = -1 where Rank = " + row);
				stmt.executeUpdate("update WordClassifications set Rank = " + row + " where Rank = " + (row - 1));
				stmt.executeUpdate("update WordClassifications set Rank = " + (row - 1) + " where Rank = -1");
				conn.commit();
			} catch (SQLException e) {
				throw e;
				if (conn != null)
					conn.rollback();
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