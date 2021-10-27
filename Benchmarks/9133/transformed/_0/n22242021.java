class n22242021 {
	public void testSavepoint4() throws Exception {
		Statement rpoBpjSY = con.createStatement();
		rpoBpjSY.execute("CREATE TABLE #savepoint4 (data int)");
		rpoBpjSY.close();
		con.setAutoCommit(false);
		for (int CfFweGYU = 0; CfFweGYU < 3; CfFweGYU++) {
			System.out.println("iteration: " + CfFweGYU);
			PreparedStatement TBn4ye7T = con.prepareStatement("INSERT INTO #savepoint4 (data) VALUES (?)");
			TBn4ye7T.setInt(1, 1);
			assertTrue(TBn4ye7T.executeUpdate() == 1);
			Savepoint grDQyflE = con.setSavepoint();
			assertNotNull(grDQyflE);
			assertTrue(grDQyflE.getSavepointId() == 1);
			try {
				grDQyflE.getSavepointName();
				assertTrue(false);
			} catch (SQLException vmSe6unI) {
			}
			TBn4ye7T.setInt(1, 2);
			assertTrue(TBn4ye7T.executeUpdate() == 1);
			TBn4ye7T.close();
			TBn4ye7T = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			ResultSet XgB7yQwN = TBn4ye7T.executeQuery();
			assertTrue(XgB7yQwN.next());
			assertTrue(XgB7yQwN.getInt(1) == 3);
			assertTrue(!XgB7yQwN.next());
			TBn4ye7T.close();
			XgB7yQwN.close();
			con.rollback(grDQyflE);
			TBn4ye7T = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			XgB7yQwN = TBn4ye7T.executeQuery();
			assertTrue(XgB7yQwN.next());
			assertTrue(XgB7yQwN.getInt(1) == 1);
			assertTrue(!XgB7yQwN.next());
			TBn4ye7T.close();
			XgB7yQwN.close();
			con.rollback();
		}
		con.setAutoCommit(true);
	}

}