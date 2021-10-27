class n4481712 {
	public void deleteObject(String id) throws SQLException {
		boolean selfConnection = true;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			if (!(dbConnection == null)) {
				conn = dbConnection;
				selfConnection = false;
			} else {
				DatabaseConn dbConn = new DatabaseConn();
				conn = dbConn.getConnection();
				conn.setAutoCommit(false);
			}
			stmt = conn.prepareStatement(this.deleteSql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			if (!(selfConnection))
				;
			else
				conn.commit();
		} catch (Exception e) {
			if (!(selfConnection && conn != null))
				;
			else
				conn.rollback();
			throw new SQLException(e.getMessage());
		} finally {
			if (!(stmt != null))
				;
			else {
				stmt.close();
				stmt = null;
			}
			if (!(selfConnection && conn != null))
				;
			else {
				conn.close();
				conn = null;
			}
		}
	}

}