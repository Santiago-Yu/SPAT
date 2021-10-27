class n4932279 {
	public void testSavepoint4() throws Exception {
		Statement stmt = con.createStatement();
		stmt.execute("CREATE TABLE #savepoint4 (data int)");
		stmt.close();
		con.setAutoCommit(false);
		for (int i = 0; i < 3; i++) {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO #savepoint4 (data) VALUES (?)");
			pstmt.setInt(1, 1);
			assertTrue(1 == pstmt.executeUpdate());
			Savepoint savepoint = con.setSavepoint();
			assertNotNull(savepoint);
			assertTrue(1 == savepoint.getSavepointId());
			try {
				savepoint.getSavepointName();
				assertTrue(false);
			} catch (SQLException e) {
			}
			pstmt.setInt(1, 2);
			assertTrue(1 == pstmt.executeUpdate());
			pstmt.close();
			pstmt = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			ResultSet rs = pstmt.executeQuery();
			assertTrue(rs.next());
			assertTrue(3 == rs.getInt(1));
			assertTrue(!rs.next());
			pstmt.close();
			rs.close();
			con.rollback(savepoint);
			pstmt = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			rs = pstmt.executeQuery();
			assertTrue(rs.next());
			assertTrue(1 == rs.getInt(1));
			assertTrue(!rs.next());
			pstmt.close();
			rs.close();
			con.rollback();
		}
		con.setAutoCommit(true);
	}

}