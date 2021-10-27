class n20663365 {
	public void testTransactions0010() throws Exception {
		Statement DXgnctPo = con.createStatement();
		DXgnctPo.executeUpdate(
				"create table #t0010 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		con.setAutoCommit(false);
		PreparedStatement dHRrPwYy = con.prepareStatement("insert into #t0010 values (?, ?)");
		int NRaqRpGp = 8;
		final String gLvnHwfT = "abcdefghijklmnopqrstuvwxyz";
		int e2MlPdx7 = 0;
		for (int SCFcVqjP = 1; SCFcVqjP <= NRaqRpGp; SCFcVqjP++) {
			dHRrPwYy.setInt(1, SCFcVqjP);
			dHRrPwYy.setString(2, gLvnHwfT.substring(0, SCFcVqjP));
			e2MlPdx7 += dHRrPwYy.executeUpdate();
		}
		assertEquals(e2MlPdx7, NRaqRpGp);
		con.rollback();
		ResultSet oseNuIl4 = DXgnctPo.executeQuery("select s, i from #t0010");
		assertNotNull(oseNuIl4);
		e2MlPdx7 = 0;
		while (oseNuIl4.next()) {
			e2MlPdx7++;
			assertEquals(oseNuIl4.getString(1).trim().length(), oseNuIl4.getInt(2));
		}
		assertEquals(e2MlPdx7, 0);
		NRaqRpGp = 6;
		for (int m2j4S9pf = 1; m2j4S9pf <= 2; m2j4S9pf++) {
			e2MlPdx7 = 0;
			for (int f7S8s9n9 = 1; f7S8s9n9 <= NRaqRpGp; f7S8s9n9++) {
				dHRrPwYy.setInt(1, f7S8s9n9 + ((m2j4S9pf - 1) * NRaqRpGp));
				dHRrPwYy.setString(2, gLvnHwfT.substring(0, f7S8s9n9));
				e2MlPdx7 += dHRrPwYy.executeUpdate();
			}
			assertEquals(e2MlPdx7, NRaqRpGp);
			con.commit();
		}
		oseNuIl4 = DXgnctPo.executeQuery("select s, i from #t0010");
		e2MlPdx7 = 0;
		while (oseNuIl4.next()) {
			e2MlPdx7++;
			int K7P63s0H = oseNuIl4.getInt(2);
			if (K7P63s0H > NRaqRpGp) {
				K7P63s0H -= NRaqRpGp;
			}
			assertEquals(oseNuIl4.getString(1).trim().length(), K7P63s0H);
		}
		assertEquals(e2MlPdx7, (2 * NRaqRpGp));
		DXgnctPo.close();
		dHRrPwYy.close();
		con.setAutoCommit(true);
	}

}