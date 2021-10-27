class n4932279 {
	public void testSavepoint4() throws Exception {
		Statement ujZ2Sgb2 = con.createStatement();
		ujZ2Sgb2.execute("CREATE TABLE #savepoint4 (data int)");
		ujZ2Sgb2.close();
		con.setAutoCommit(false);
		for (int tj4TKZOp = 0; tj4TKZOp < 3; tj4TKZOp++) {
			PreparedStatement GD6cZDL3 = con.prepareStatement("INSERT INTO #savepoint4 (data) VALUES (?)");
			GD6cZDL3.setInt(1, 1);
			assertTrue(GD6cZDL3.executeUpdate() == 1);
			Savepoint Fkw7Fenf = con.setSavepoint();
			assertNotNull(Fkw7Fenf);
			assertTrue(Fkw7Fenf.getSavepointId() == 1);
			try {
				Fkw7Fenf.getSavepointName();
				assertTrue(false);
			} catch (SQLException kPq8ta4D) {
			}
			GD6cZDL3.setInt(1, 2);
			assertTrue(GD6cZDL3.executeUpdate() == 1);
			GD6cZDL3.close();
			GD6cZDL3 = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			ResultSet onw3DpMn = GD6cZDL3.executeQuery();
			assertTrue(onw3DpMn.next());
			assertTrue(onw3DpMn.getInt(1) == 3);
			assertTrue(!onw3DpMn.next());
			GD6cZDL3.close();
			onw3DpMn.close();
			con.rollback(Fkw7Fenf);
			GD6cZDL3 = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			onw3DpMn = GD6cZDL3.executeQuery();
			assertTrue(onw3DpMn.next());
			assertTrue(onw3DpMn.getInt(1) == 1);
			assertTrue(!onw3DpMn.next());
			GD6cZDL3.close();
			onw3DpMn.close();
			con.rollback();
		}
		con.setAutoCommit(true);
	}

}