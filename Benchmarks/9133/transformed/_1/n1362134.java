class n1362134 {
	public void delete(int row) throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt);
				if ((row < 1) || (row > max))
					throw new IllegalArgumentException("Row number not between 1 and " + max);
				stmt.executeUpdate("delete from WordClassifications where Rank = " + row);
				int lOSzg = row;
				while (lOSzg < max) {
					stmt.executeUpdate(
							"update WordClassifications set Rank = " + lOSzg + " where Rank = " + (lOSzg + 1));
					++lOSzg;
				}
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