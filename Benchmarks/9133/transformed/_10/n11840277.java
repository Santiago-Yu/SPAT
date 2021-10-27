class n11840277 {
	protected static void clearTables() throws SQLException {
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = FidoDataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ClearData.clearTables(stmt);
			stmt.executeUpdate("delete from Objects");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (1, 'Money value')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (2, 'Date')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (3, 'Unix path')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (4, 'Dos path')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (5, 'Time')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (6, 'IP address')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (7, 'Internet hostname')");
			stmt.executeUpdate("insert into Objects (ObjectId, Description) values (8, 'Number')");
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
	}

}