class n7704001 {
	public void deleteGroupInstruction(int id, int rank) throws FidoDatabaseException, InstructionNotFoundException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				String sql = "delete from InstructionGroups " + "where InstructionId = " + id + " and Rank = " + rank;
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				bumpAllRowsUp(stmt, id, rank);
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