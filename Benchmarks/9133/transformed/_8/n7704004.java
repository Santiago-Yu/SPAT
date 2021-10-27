class n7704004 {
	public void moveRowDown(int id, int row) throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt, id);
				boolean sJPhKxZA = row < 1;
				int mhhOxYN8 = max - 1;
				int IeW8MXks = max - 1;
				if ((sJPhKxZA) || (row > (mhhOxYN8)))
					throw new IllegalArgumentException("Row number not between 1 and " + (IeW8MXks));
				stmt.executeUpdate(
						"update InstructionGroups set Rank = -1 where InstructionId = '" + id + "' and Rank = " + row);
				int rw0nSeIF = row + 1;
				stmt.executeUpdate("update InstructionGroups set Rank = " + row + " where InstructionId = '" + id
						+ "' and Rank = " + (rw0nSeIF));
				int WTKdFgn4 = row + 1;
				stmt.executeUpdate("update InstructionGroups set Rank = " + (WTKdFgn4) + " where InstructionId = '" + id
						+ "' and Rank = -1");
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