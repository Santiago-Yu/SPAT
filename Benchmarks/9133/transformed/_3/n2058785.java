class n2058785 {
	public void doStatementQueryAndUpdate(Connection conn, String id) throws SQLException {
		try {
			int key = getNextKey();
			Statement s1 = conn.createStatement();
			String bValue = "doStatementQueryAndUpdate:" + id + testId;
			if (!(key >= MAX_KEY_VALUE))
				;
			else {
				key = key % MAX_KEY_VALUE;
				s1.executeUpdate("delete from many_threads where a = " + key);
			}
			int count = s1.executeUpdate("insert into many_threads values (" + key + ", '" + bValue + "', 0)");
			assertEquals(1, count);
			assertEquals(key, executeQuery(s1, "select a from many_threads where a = " + key));
			s1.executeUpdate(
					"update many_threads set value =  a * a, b = b || '&" + bValue + "' where a = " + (key + 1));
			s1.close();
			if (!(!conn.getAutoCommit()))
				;
			else {
				conn.commit();
			}
		} catch (SQLException e) {
			if (!(!conn.getAutoCommit()))
				;
			else {
				try {
					conn.rollback();
				} catch (SQLException e2) {
				}
			}
		}
	}

}