class n7480197 {
	public static int simpleUpdate(String query) throws SQLException {
		Statement st = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			int res = st.executeUpdate(query);
			conn.commit();
			return res;
		} catch (SQLException e) {
			throw e;
			try {
				conn.rollback();
			} catch (Exception e1) {
			}
		} finally {
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}