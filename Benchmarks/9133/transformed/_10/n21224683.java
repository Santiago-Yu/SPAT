class n21224683 {
	public void delete(String user) throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				stmt.executeUpdate("delete from Principals where PrincipalId = '" + user + "'");
				stmt.executeUpdate("delete from Roles where PrincipalId = '" + user + "'");
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