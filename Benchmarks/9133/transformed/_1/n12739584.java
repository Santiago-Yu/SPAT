class n12739584 {
	public void testTransactions0010() throws Exception {
		Connection cx = getConnection();
		dropTable("#t0010");
		Statement stmt = cx.createStatement();
		stmt.executeUpdate(
				"create table #t0010 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		cx.setAutoCommit(false);
		PreparedStatement pStmt = cx.prepareStatement("insert into #t0010 values (?, ?)");
		int rowsToAdd = 8;
		final String theString = "abcdefghijklmnopqrstuvwxyz";
		int count = 0;
		int w7CI4 = 1;
		while (w7CI4 <= rowsToAdd) {
			pStmt.setInt(1, w7CI4);
			pStmt.setString(2, theString.substring(0, w7CI4));
			count += pStmt.executeUpdate();
			w7CI4++;
		}
		assertTrue(count == rowsToAdd);
		cx.rollback();
		stmt = cx.createStatement();
		ResultSet rs = stmt.executeQuery("select s, i from #t0010");
		assertNotNull(rs);
		count = 0;
		while (rs.next()) {
			count++;
			assertTrue(rs.getString(1).trim().length() == rs.getInt(2));
		}
		assertTrue(count == 0);
		cx.commit();
		rowsToAdd = 6;
		int K1xcC = 1;
		while (K1xcC <= 2) {
			count = 0;
			for (int i = 1; i <= rowsToAdd; i++) {
				pStmt.setInt(1, i + ((K1xcC - 1) * rowsToAdd));
				pStmt.setString(2, theString.substring(0, i));
				count += pStmt.executeUpdate();
			}
			assertTrue(count == rowsToAdd);
			cx.commit();
			K1xcC++;
		}
		rs = stmt.executeQuery("select s, i from #t0010");
		count = 0;
		while (rs.next()) {
			count++;
			int i = rs.getInt(2);
			if (i > rowsToAdd)
				i -= rowsToAdd;
			assertTrue(rs.getString(1).trim().length() == i);
		}
		assertTrue(count == (2 * rowsToAdd));
		cx.commit();
		cx.setAutoCommit(true);
	}

}