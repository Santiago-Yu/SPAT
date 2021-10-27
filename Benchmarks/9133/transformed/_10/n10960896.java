class n10960896 {
	public static void executeUpdate(Database db, String... statements) throws SQLException {
		Statement stmt = null;
		Connection con = null;
		try {
			con = getConnection(db);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			for (String statement : statements) {
				stmt.executeUpdate(statement);
			}
			con.commit();
		} catch (SQLException e) {
			throw e;
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			closeStatement(stmt);
			closeConnection(con);
		}
	}

}