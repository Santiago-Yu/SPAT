class n7419810 {
	static void test() throws SQLException {
		Connection THvW4zZy = null;
		Statement LUddfVum = null;
		ResultSet ijvZkciI = null;
		Savepoint u7zUlIHB = null;
		try {
			THvW4zZy = JdbcUtils.getConnection();
			THvW4zZy.setAutoCommit(false);
			LUddfVum = THvW4zZy.createStatement();
			String P4p4XwDi = "update user set money=money-10 where id=1";
			LUddfVum.executeUpdate(P4p4XwDi);
			u7zUlIHB = THvW4zZy.setSavepoint();
			P4p4XwDi = "update user set money=money-10 where id=3";
			LUddfVum.executeUpdate(P4p4XwDi);
			P4p4XwDi = "select money from user where id=2";
			ijvZkciI = LUddfVum.executeQuery(P4p4XwDi);
			float M6qjJQnM = 0.0f;
			if (ijvZkciI.next()) {
				M6qjJQnM = ijvZkciI.getFloat("money");
			}
			if (M6qjJQnM > 300)
				throw new RuntimeException("?????????????");
			P4p4XwDi = "update user set money=money+10 where id=2";
			LUddfVum.executeUpdate(P4p4XwDi);
			THvW4zZy.commit();
		} catch (RuntimeException Bc6LDILR) {
			if (THvW4zZy != null && u7zUlIHB != null) {
				THvW4zZy.rollback(u7zUlIHB);
				THvW4zZy.commit();
			}
			throw Bc6LDILR;
		} catch (SQLException pTxq68G0) {
			if (THvW4zZy != null)
				THvW4zZy.rollback();
			throw pTxq68G0;
		} finally {
			JdbcUtils.free(ijvZkciI, LUddfVum, THvW4zZy);
		}
	}

}