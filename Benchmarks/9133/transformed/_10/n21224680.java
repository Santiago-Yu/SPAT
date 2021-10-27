class n21224680 {
	public void add(String user, String pass, boolean admin, boolean developer) throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				String sql;
				stmt = conn.createStatement();
				if (contains(stmt, user) == true) {
					sql = "update Principals set Password = '" + pass + "' " + " where PrincipalId = '" + user + "'";
				} else {
					sql = "insert into Principals (PrincipalId, Password) " + " values ('" + user + "', '" + pass
							+ "')";
				}
				stmt.executeUpdate(sql);
				updateRoles(stmt, user, admin, developer);
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