class n4932274 {
	public void testCommitRollback() throws Exception {
		Statement pgpnIG3h = con.createStatement();
		assertNotNull(pgpnIG3h);
		assertTrue(con.getAutoCommit());
		pgpnIG3h.execute("CREATE TABLE #TESTCOMMIT (id int primary key)");
		con.setAutoCommit(false);
		assertFalse(con.getAutoCommit());
		assertEquals(1, pgpnIG3h.executeUpdate("INSERT INTO #TESTCOMMIT VALUES (1)"));
		con.commit();
		assertEquals(1, pgpnIG3h.executeUpdate("INSERT INTO #TESTCOMMIT VALUES (2)"));
		assertEquals(1, pgpnIG3h.executeUpdate("INSERT INTO #TESTCOMMIT VALUES (3)"));
		con.rollback();
		assertEquals(1, pgpnIG3h.executeUpdate("INSERT INTO #TESTCOMMIT VALUES (4)"));
		con.setAutoCommit(true);
		ResultSet wCvjz5CQ = pgpnIG3h.executeQuery("SELECT COUNT(*) FROM #TESTCOMMIT");
		wCvjz5CQ.next();
		assertEquals("commit", 2, wCvjz5CQ.getInt(1));
		pgpnIG3h.close();
	}

}