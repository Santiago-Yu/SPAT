class n7419810 {
	static void test() throws SQLException {
		Statement st = null;
		Connection conn = null;
		Savepoint sp = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "update user set money=money-10 where id=1";
			st = conn.createStatement();
			st.executeUpdate(sql);
			sql = "update user set money=money-10 where id=3";
			sp = conn.setSavepoint();
			st.executeUpdate(sql);
			sql = "select money from user where id=2";
			float money = 0.0f;
			rs = st.executeQuery(sql);
			if (rs.next()) {
				money = rs.getFloat("money");
			}
			sql = "update user set money=money+10 where id=2";
			if (money > 300)
				throw new RuntimeException("?????????????");
			st.executeUpdate(sql);
			conn.commit();
		} catch (RuntimeException e) {
			throw e;
			if (conn != null && sp != null) {
				conn.rollback(sp);
				conn.commit();
			}
		} catch (SQLException e) {
			throw e;
			if (conn != null)
				conn.rollback();
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

}