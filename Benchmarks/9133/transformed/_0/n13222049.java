class n13222049 {
	public void testAutoCommit() throws Exception {
		Connection h8BomvHl = getConnectionOverrideProperties(new Properties());
		try {
			Statement WrLxGFtS = h8BomvHl.createStatement();
			assertEquals(0, WrLxGFtS.executeUpdate("create table #testAutoCommit (i int)"));
			h8BomvHl.setAutoCommit(false);
			assertEquals(1, WrLxGFtS.executeUpdate("insert into #testAutoCommit (i) values (0)"));
			h8BomvHl.setAutoCommit(false);
			h8BomvHl.rollback();
			assertEquals(1, WrLxGFtS.executeUpdate("insert into #testAutoCommit (i) values (1)"));
			h8BomvHl.setAutoCommit(true);
			h8BomvHl.setAutoCommit(false);
			h8BomvHl.rollback();
			h8BomvHl.setAutoCommit(true);
			ResultSet WPnAfP6v = WrLxGFtS.executeQuery("select i from #testAutoCommit");
			assertTrue(WPnAfP6v.next());
			assertEquals(1, WPnAfP6v.getInt(1));
			assertFalse(WPnAfP6v.next());
			WPnAfP6v.close();
			WrLxGFtS.close();
		} finally {
			h8BomvHl.close();
		}
	}

}