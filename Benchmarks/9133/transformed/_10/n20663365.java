class n20663365 {
	public void testTransactions0010() throws Exception {
		Statement stmt = con.createStatement();
		stmt.executeUpdate(
				"create table #t0010 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		con.setAutoCommit(false);
		int rowsToAdd = 8;
		PreparedStatement pstmt = con.prepareStatement("insert into #t0010 values (?, ?)");
		int count = 0;
		final String theString = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 1; i <= rowsToAdd; i++) {
			pstmt.setInt(1, i);
			pstmt.setString(2, theString.substring(0, i));
			count += pstmt.executeUpdate();
		}
		assertEquals(count, rowsToAdd);
		con.rollback();
		ResultSet rs = stmt.executeQuery("select s, i from #t0010");
		assertNotNull(rs);
		count = 0;
		while (rs.next()) {
			count++;
			assertEquals(rs.getString(1).trim().length(), rs.getInt(2));
		}
		assertEquals(count, 0);
		rowsToAdd = 6;
		for (int j = 1; j <= 2; j++) {
			count = 0;
			for (int i = 1; i <= rowsToAdd; i++) {
				pstmt.setInt(1, i + ((j - 1) * rowsToAdd));
				pstmt.setString(2, theString.substring(0, i));
				count += pstmt.executeUpdate();
			}
			assertEquals(count, rowsToAdd);
			con.commit();
		}
		count = 0;
		rs = stmt.executeQuery("select s, i from #t0010");
		while (rs.next()) {
			int i = rs.getInt(2);
			count++;
			if (i > rowsToAdd) {
				i -= rowsToAdd;
			}
			assertEquals(rs.getString(1).trim().length(), i);
		}
		assertEquals(count, (2 * rowsToAdd));
		stmt.close();
		pstmt.close();
		con.setAutoCommit(true);
	}

}