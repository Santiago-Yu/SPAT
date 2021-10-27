class n2362300 {
	static void test() throws SQLException {
		Statement st = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "update user set money=money-10 where id=15";
			st = conn.createStatement();
			st.executeUpdate(sql);
			sql = "select money from user where id=13";
			float money = 0.0f;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				money = rs.getFloat("money");
			}
			sql = "update user set money=money+10 where id=13";
			if (money > 1000)
				throw new RuntimeException("?????????????");
			st.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			throw e;
			if (conn != null)
				conn.rollback();
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

}