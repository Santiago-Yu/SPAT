class n1293658 {
	public int addCollectionInstruction() throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				String sql = "insert into Instructions (Type, Operator) " + "values (1, 0)";
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				return getCurrentId(stmt);
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