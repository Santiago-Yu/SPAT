class n1293658 {
	public int addCollectionInstruction() throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				String sql = "insert into Instructions (Type, Operator) " + "values (1, 0)";
				conn = fido.util.FidoDataSource.getConnection();
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				return getCurrentId(stmt);
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