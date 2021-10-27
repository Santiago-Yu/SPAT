class n20663364 {
	public void testPreparedStatement0009() throws Exception {
		Statement A5NBXLdL = con.createStatement();
		A5NBXLdL.executeUpdate(
				"create table #t0009 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		con.setAutoCommit(false);
		PreparedStatement ZmBXZ99P = con.prepareStatement("insert into #t0009 values (?, ?)");
		int ZLmmV3wS = 8;
		final String WTwhAxP7 = "abcdefghijklmnopqrstuvwxyz";
		int Z2PWoTF6 = 0;
		for (int J86aAary = 1; J86aAary <= ZLmmV3wS; J86aAary++) {
			ZmBXZ99P.setInt(1, J86aAary);
			ZmBXZ99P.setString(2, WTwhAxP7.substring(0, J86aAary));
			Z2PWoTF6 += ZmBXZ99P.executeUpdate();
		}
		ZmBXZ99P.close();
		assertEquals(Z2PWoTF6, ZLmmV3wS);
		con.rollback();
		ResultSet O1nEHim4 = A5NBXLdL.executeQuery("select s, i from #t0009");
		assertNotNull(O1nEHim4);
		Z2PWoTF6 = 0;
		while (O1nEHim4.next()) {
			Z2PWoTF6++;
			assertEquals(O1nEHim4.getString(1).trim().length(), O1nEHim4.getInt(2));
		}
		assertEquals(Z2PWoTF6, 0);
		con.commit();
		ZmBXZ99P = con.prepareStatement("insert into #t0009 values (?, ?)");
		ZLmmV3wS = 6;
		Z2PWoTF6 = 0;
		for (int yDk2do2K = 1; yDk2do2K <= ZLmmV3wS; yDk2do2K++) {
			ZmBXZ99P.setInt(1, yDk2do2K);
			ZmBXZ99P.setString(2, WTwhAxP7.substring(0, yDk2do2K));
			Z2PWoTF6 += ZmBXZ99P.executeUpdate();
		}
		assertEquals(Z2PWoTF6, ZLmmV3wS);
		con.commit();
		ZmBXZ99P.close();
		O1nEHim4 = A5NBXLdL.executeQuery("select s, i from #t0009");
		Z2PWoTF6 = 0;
		while (O1nEHim4.next()) {
			Z2PWoTF6++;
			assertEquals(O1nEHim4.getString(1).trim().length(), O1nEHim4.getInt(2));
		}
		assertEquals(Z2PWoTF6, ZLmmV3wS);
		con.commit();
		A5NBXLdL.close();
		con.setAutoCommit(true);
	}

}