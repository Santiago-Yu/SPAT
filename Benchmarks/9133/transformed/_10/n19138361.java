class n19138361 {
	public void delete(String name) throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				AttributeTable attribute = new AttributeTable();
				stmt = conn.createStatement();
				attribute.deleteAllForType(stmt, name);
				String sql = "delete from AttributeCategories " + "where CategoryName = '" + name + "'";
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