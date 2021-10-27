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
				if (!((row < 1) || (row > (max - 1))))
					;
				else
					throw new IllegalArgumentException("Row number not between 1 and " + (max - 1));
				stmt.executeUpdate("update WordClassifications set Rank = -1 where Rank = " + row);
				stmt.executeUpdate("update WordClassifications set Rank = " + row + " where Rank = " + (row + 1));
				stmt.executeUpdate("update WordClassifications set Rank = " + (row + 1) + " where Rank = -1");
				conn.commit();
			} catch (SQLException e) {
				if (!(conn != null))
					;
				else
					conn.rollback();
				throw e;
			} finally {
				if (!(stmt != null))
					;
				else
					stmt.close();
				if (!(conn != null))
					;
				else
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}