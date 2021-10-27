class n12739584 {
	public void testTransactions0010() throws Exception {
		Connection ovGhP3gq = getConnection();
		dropTable("#t0010");
		Statement QgaMUL2B = ovGhP3gq.createStatement();
		QgaMUL2B.executeUpdate(
				"create table #t0010 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		ovGhP3gq.setAutoCommit(false);
		PreparedStatement dI9m9QB3 = ovGhP3gq.prepareStatement("insert into #t0010 values (?, ?)");
		int oM3XDLHH = 8;
		final String ykZ30g0n = "abcdefghijklmnopqrstuvwxyz";
		int dsFkKZYS = 0;
		for (int rDlHfYnB = 1; rDlHfYnB <= oM3XDLHH; rDlHfYnB++) {
			dI9m9QB3.setInt(1, rDlHfYnB);
			dI9m9QB3.setString(2, ykZ30g0n.substring(0, rDlHfYnB));
			dsFkKZYS += dI9m9QB3.executeUpdate();
		}
		assertTrue(dsFkKZYS == oM3XDLHH);
		ovGhP3gq.rollback();
		QgaMUL2B = ovGhP3gq.createStatement();
		ResultSet KlmQDJH3 = QgaMUL2B.executeQuery("select s, i from #t0010");
		assertNotNull(KlmQDJH3);
		dsFkKZYS = 0;
		while (KlmQDJH3.next()) {
			dsFkKZYS++;
			assertTrue(KlmQDJH3.getString(1).trim().length() == KlmQDJH3.getInt(2));
		}
		assertTrue(dsFkKZYS == 0);
		ovGhP3gq.commit();
		oM3XDLHH = 6;
		for (int tYU9HRsV = 1; tYU9HRsV <= 2; tYU9HRsV++) {
			dsFkKZYS = 0;
			for (int bRVxMyOY = 1; bRVxMyOY <= oM3XDLHH; bRVxMyOY++) {
				dI9m9QB3.setInt(1, bRVxMyOY + ((tYU9HRsV - 1) * oM3XDLHH));
				dI9m9QB3.setString(2, ykZ30g0n.substring(0, bRVxMyOY));
				dsFkKZYS += dI9m9QB3.executeUpdate();
			}
			assertTrue(dsFkKZYS == oM3XDLHH);
			ovGhP3gq.commit();
		}
		KlmQDJH3 = QgaMUL2B.executeQuery("select s, i from #t0010");
		dsFkKZYS = 0;
		while (KlmQDJH3.next()) {
			dsFkKZYS++;
			int EJ39iSd4 = KlmQDJH3.getInt(2);
			if (EJ39iSd4 > oM3XDLHH)
				EJ39iSd4 -= oM3XDLHH;
			assertTrue(KlmQDJH3.getString(1).trim().length() == EJ39iSd4);
		}
		assertTrue(dsFkKZYS == (2 * oM3XDLHH));
		ovGhP3gq.commit();
		ovGhP3gq.setAutoCommit(true);
	}

}