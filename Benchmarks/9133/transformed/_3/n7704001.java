class n7704001 {
	public void deleteGroupInstruction(int id, int rank) throws FidoDatabaseException, InstructionNotFoundException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				String sql = "delete from InstructionGroups " + "where InstructionId = " + id + " and Rank = " + rank;
				stmt.executeUpdate(sql);
				bumpAllRowsUp(stmt, id, rank);
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