class n4481712 {
	public void deleteObject(String id) throws SQLException {
		Connection conn = null;
		boolean selfConnection = true;
		PreparedStatement stmt = null;
		try {
			if (dbConnection == null) {
				DatabaseConn dbConn = new DatabaseConn();
				conn = dbConn.getConnection();
				conn.setAutoCommit(false);
			} else {
				selfConnection = false;
				conn = dbConnection;
			}
			stmt = conn.prepareStatement(this.deleteSql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			if (selfConnection)
				conn.commit();
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
			if (selfConnection && conn != null)
				conn.rollback();
		} finally {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (selfConnection && conn != null) {
				conn.close();
				conn = null;
			}
		}
	}

}