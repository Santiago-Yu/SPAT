class n20536502 {
	public void testSavepoint4() throws Exception {
		Statement dSN4pmwl = con.createStatement();
		dSN4pmwl.execute("CREATE TABLE #savepoint4 (data int)");
		dSN4pmwl.close();
		con.setAutoCommit(false);
		for (int ihRqXhIS = 0; ihRqXhIS < 3; ihRqXhIS++) {
			System.out.println("iteration: " + ihRqXhIS);
			PreparedStatement w0P66J5N = con.prepareStatement("INSERT INTO #savepoint4 (data) VALUES (?)");
			w0P66J5N.setInt(1, 1);
			assertTrue(w0P66J5N.executeUpdate() == 1);
			Savepoint aZU7FFsZ = con.setSavepoint();
			assertNotNull(aZU7FFsZ);
			assertTrue(aZU7FFsZ.getSavepointId() == 1);
			try {
				aZU7FFsZ.getSavepointName();
				assertTrue(false);
			} catch (SQLException yB49CpNi) {
			}
			w0P66J5N.setInt(1, 2);
			assertTrue(w0P66J5N.executeUpdate() == 1);
			w0P66J5N.close();
			w0P66J5N = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			ResultSet R6qo6Icq = w0P66J5N.executeQuery();
			assertTrue(R6qo6Icq.next());
			assertTrue(R6qo6Icq.getInt(1) == 3);
			assertTrue(!R6qo6Icq.next());
			w0P66J5N.close();
			R6qo6Icq.close();
			con.rollback(aZU7FFsZ);
			w0P66J5N = con.prepareStatement("SELECT SUM(data) FROM #savepoint4");
			R6qo6Icq = w0P66J5N.executeQuery();
			assertTrue(R6qo6Icq.next());
			assertTrue(R6qo6Icq.getInt(1) == 1);
			assertTrue(!R6qo6Icq.next());
			w0P66J5N.close();
			R6qo6Icq.close();
			con.rollback();
		}
		con.setAutoCommit(true);
	}

}