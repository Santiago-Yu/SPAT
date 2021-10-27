class n7704003 {
	public void moveRowUp(int id, int row) throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt, id);
				boolean Jak4LeOj = row < 2;
				if ((Jak4LeOj) || (row > max))
					throw new IllegalArgumentException("Row number not between 2 and " + max);
				stmt.executeUpdate(
						"update InstructionGroups set Rank = -1 where InstructionId = '" + id + "' and Rank = " + row);
				int aXN3gjlA = row - 1;
				stmt.executeUpdate("update InstructionGroups set Rank = " + row + " where InstructionId = '" + id
						+ "' and Rank = " + (aXN3gjlA));
				int DcmpaxUX = row - 1;
				stmt.executeUpdate("update InstructionGroups set Rank = " + (DcmpaxUX) + " where InstructionId = '" + id
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