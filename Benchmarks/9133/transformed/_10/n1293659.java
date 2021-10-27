class n1293659 {
	public void delete(int id) throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				String sql = "delete from Instructions where InstructionId = " + id;
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				sql = "delete from InstructionGroups where InstructionId = " + id;
				stmt.executeUpdate(sql);
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