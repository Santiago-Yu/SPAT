class n12739583 {
	public void testPreparedStatement0009() throws Exception {
		Connection BWsWYyr2 = getConnection();
		dropTable("#t0009");
		Statement cy140HwV = BWsWYyr2.createStatement();
		cy140HwV.executeUpdate(
				"create table #t0009 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		BWsWYyr2.setAutoCommit(false);
		PreparedStatement pBblCfyW = BWsWYyr2.prepareStatement("insert into #t0009 values (?, ?)");
		int HI5wfD2G = 8;
		final String KqIaO8y5 = "abcdefghijklmnopqrstuvwxyz";
		int DPxjiQx3 = 0;
		for (int qcQOhPkW = 1; qcQOhPkW <= HI5wfD2G; qcQOhPkW++) {
			pBblCfyW.setInt(1, qcQOhPkW);
			pBblCfyW.setString(2, KqIaO8y5.substring(0, qcQOhPkW));
			DPxjiQx3 += pBblCfyW.executeUpdate();
		}
		assertTrue(DPxjiQx3 == HI5wfD2G);
		BWsWYyr2.rollback();
		cy140HwV = BWsWYyr2.createStatement();
		ResultSet bJij9cgu = cy140HwV.executeQuery("select s, i from #t0009");
		assertNotNull(bJij9cgu);
		DPxjiQx3 = 0;
		while (bJij9cgu.next()) {
			DPxjiQx3++;
			assertTrue(bJij9cgu.getString(1).trim().length() == bJij9cgu.getInt(2));
		}
		assertTrue(DPxjiQx3 == 0);
		BWsWYyr2.commit();
		HI5wfD2G = 6;
		DPxjiQx3 = 0;
		for (int gGy5UOdJ = 1; gGy5UOdJ <= HI5wfD2G; gGy5UOdJ++) {
			pBblCfyW.setInt(1, gGy5UOdJ);
			pBblCfyW.setString(2, KqIaO8y5.substring(0, gGy5UOdJ));
			DPxjiQx3 += pBblCfyW.executeUpdate();
		}
		assertTrue(DPxjiQx3 == HI5wfD2G);
		BWsWYyr2.commit();
		bJij9cgu = cy140HwV.executeQuery("select s, i from #t0009");
		DPxjiQx3 = 0;
		while (bJij9cgu.next()) {
			DPxjiQx3++;
			assertTrue(bJij9cgu.getString(1).trim().length() == bJij9cgu.getInt(2));
		}
		assertTrue(DPxjiQx3 == HI5wfD2G);
		BWsWYyr2.commit();
		BWsWYyr2.setAutoCommit(true);
	}

}