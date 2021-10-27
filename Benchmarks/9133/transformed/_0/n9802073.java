class n9802073 {
	public void testAutoCommit() throws Exception {
		Connection YNmoniQx = getConnectionOverrideProperties(new Properties());
		try {
			Statement GsSYKigF = YNmoniQx.createStatement();
			assertEquals(0, GsSYKigF.executeUpdate("create table #testAutoCommit (i int)"));
			YNmoniQx.setAutoCommit(false);
			assertEquals(1, GsSYKigF.executeUpdate("insert into #testAutoCommit (i) values (0)"));
			YNmoniQx.setAutoCommit(false);
			YNmoniQx.rollback();
			assertEquals(1, GsSYKigF.executeUpdate("insert into #testAutoCommit (i) values (1)"));
			YNmoniQx.setAutoCommit(true);
			YNmoniQx.setAutoCommit(false);
			YNmoniQx.rollback();
			YNmoniQx.setAutoCommit(true);
			ResultSet brw134Xe = GsSYKigF.executeQuery("select i from #testAutoCommit");
			assertTrue(brw134Xe.next());
			assertEquals(1, brw134Xe.getInt(1));
			assertFalse(brw134Xe.next());
			brw134Xe.close();
			GsSYKigF.close();
		} finally {
			YNmoniQx.close();
		}
	}

}