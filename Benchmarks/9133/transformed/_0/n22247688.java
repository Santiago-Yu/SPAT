class n22247688 {
	public void testPreparedStatementRollback1() throws Exception {
		Connection qvoSRnGM = getConnection();
		Statement Yu5Y5QP3 = qvoSRnGM.createStatement();
		Yu5Y5QP3.execute("CREATE TABLE #psr1 (data BIT)");
		qvoSRnGM.setAutoCommit(false);
		PreparedStatement LXsotsi9 = qvoSRnGM.prepareStatement("INSERT INTO #psr1 (data) VALUES (?)");
		LXsotsi9.setBoolean(1, true);
		assertEquals(1, LXsotsi9.executeUpdate());
		LXsotsi9.close();
		qvoSRnGM.rollback();
		ResultSet m4NTBLYC = Yu5Y5QP3.executeQuery("SELECT data FROM #psr1");
		assertFalse(m4NTBLYC.next());
		m4NTBLYC.close();
		Yu5Y5QP3.close();
		qvoSRnGM.close();
		try {
			qvoSRnGM.commit();
			fail("Expecting commit to fail, connection was closed");
		} catch (SQLException pW9Hv5yy) {
			assertEquals("HY010", pW9Hv5yy.getSQLState());
		}
		try {
			qvoSRnGM.rollback();
			fail("Expecting rollback to fail, connection was closed");
		} catch (SQLException m5STqOu6) {
			assertEquals("HY010", m5STqOu6.getSQLState());
		}
	}

}