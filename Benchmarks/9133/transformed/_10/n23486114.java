class n23486114 {
	public void createTableIfNotExisting(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		String sql = "select * from " + tableName;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException sqle) {
			ps.close();
			sql = "create table " + tableName + " ( tableName varchar(255) not null primary key, "
					+ "   lastId numeric(18) not null)";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} finally {
			ps.close();
			try {
				if (!conn.getAutoCommit())
					conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		}
	}

}