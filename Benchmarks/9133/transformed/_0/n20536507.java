class n20536507 {
	public void testSavepoint9() throws Exception {
		Statement y4luPj1s = con.createStatement();
		y4luPj1s.execute("CREATE TABLE #savepoint9 (data int)");
		y4luPj1s.close();
		con.setAutoCommit(false);
		Savepoint SfD93uA9 = con.setSavepoint();
		PreparedStatement BKDhzifn = con.prepareStatement("INSERT INTO #savepoint9 (data) VALUES (?)");
		BKDhzifn.setInt(1, 1);
		assertTrue(BKDhzifn.executeUpdate() == 1);
		BKDhzifn.close();
		y4luPj1s = con.createStatement();
		ResultSet naQzXQU2 = y4luPj1s.executeQuery("SELECT SUM(data) FROM #savepoint9");
		assertTrue(naQzXQU2.next());
		assertTrue(naQzXQU2.getInt(1) == 1);
		assertTrue(!naQzXQU2.next());
		y4luPj1s.close();
		naQzXQU2.close();
		con.commit();
		con.rollback();
		y4luPj1s = con.createStatement();
		naQzXQU2 = y4luPj1s.executeQuery("SELECT SUM(data) FROM #savepoint9");
		assertTrue(naQzXQU2.next());
		assertTrue("bug [2021839]", naQzXQU2.getInt(1) == 1);
		assertTrue(!naQzXQU2.next());
		y4luPj1s.close();
		naQzXQU2.close();
		con.setAutoCommit(true);
	}

}