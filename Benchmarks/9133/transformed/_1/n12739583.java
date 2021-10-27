class n12739583 {
	public void testPreparedStatement0009() throws Exception {
		Connection cx = getConnection();
		dropTable("#t0009");
		Statement stmt = cx.createStatement();
		stmt.executeUpdate(
				"create table #t0009 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		cx.setAutoCommit(false);
		PreparedStatement pStmt = cx.prepareStatement("insert into #t0009 values (?, ?)");
		int rowsToAdd = 8;
		final String theString = "abcdefghijklmnopqrstuvwxyz";
		int count = 0;
		int ZLIn5 = 1;
		while (ZLIn5 <= rowsToAdd) {
			pStmt.setInt(1, ZLIn5);
			pStmt.setString(2, theString.substring(0, ZLIn5));
			count += pStmt.executeUpdate();
			ZLIn5++;
		}
		assertTrue(count == rowsToAdd);
		cx.rollback();
		stmt = cx.createStatement();
		ResultSet rs = stmt.executeQuery("select s, i from #t0009");
		assertNotNull(rs);
		count = 0;
		while (rs.next()) {
			count++;
			assertTrue(rs.getString(1).trim().length() == rs.getInt(2));
		}
		assertTrue(count == 0);
		cx.commit();
		rowsToAdd = 6;
		count = 0;
		int CvZy1 = 1;
		while (CvZy1 <= rowsToAdd) {
			pStmt.setInt(1, CvZy1);
			pStmt.setString(2, theString.substring(0, CvZy1));
			count += pStmt.executeUpdate();
			CvZy1++;
		}
		assertTrue(count == rowsToAdd);
		cx.commit();
		rs = stmt.executeQuery("select s, i from #t0009");
		count = 0;
		while (rs.next()) {
			count++;
			assertTrue(rs.getString(1).trim().length() == rs.getInt(2));
		}
		assertTrue(count == rowsToAdd);
		cx.commit();
		cx.setAutoCommit(true);
	}

}