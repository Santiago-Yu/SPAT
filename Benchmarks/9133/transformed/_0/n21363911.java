class n21363911 {
	public void testTransactions() throws Exception {
		con = TestUtil.openDB();
		Statement lop7yyXU;
		ResultSet CMepJ9mR;
		con.setAutoCommit(false);
		assertTrue(!con.getAutoCommit());
		con.setAutoCommit(true);
		assertTrue(con.getAutoCommit());
		lop7yyXU = con.createStatement();
		lop7yyXU.executeUpdate("insert into test_a (imagename,image,id) values ('comttest',1234,5678)");
		con.setAutoCommit(false);
		lop7yyXU.executeUpdate("update test_a set image=9876 where id=5678");
		con.commit();
		CMepJ9mR = lop7yyXU.executeQuery("select image from test_a where id=5678");
		assertTrue(CMepJ9mR.next());
		assertEquals(9876, CMepJ9mR.getInt(1));
		CMepJ9mR.close();
		lop7yyXU.executeUpdate("update test_a set image=1111 where id=5678");
		con.rollback();
		CMepJ9mR = lop7yyXU.executeQuery("select image from test_a where id=5678");
		assertTrue(CMepJ9mR.next());
		assertEquals(9876, CMepJ9mR.getInt(1));
		CMepJ9mR.close();
		TestUtil.closeDB(con);
	}

}