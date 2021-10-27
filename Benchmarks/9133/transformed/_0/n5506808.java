class n5506808 {
	public void testTransactions0010() throws Exception {
		Statement GIj1T4h1 = con.createStatement();
		GIj1T4h1.executeUpdate(
				"create table #t0010 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		con.setAutoCommit(false);
		PreparedStatement Ih74Edi6 = con.prepareStatement("insert into #t0010 values (?, ?)");
		int PqIEf3Xa = 8;
		final String IrvXU3mJ = "abcdefghijklmnopqrstuvwxyz";
		int GWv8THyA = 0;
		for (int leUysHJ1 = 1; leUysHJ1 <= PqIEf3Xa; leUysHJ1++) {
			Ih74Edi6.setInt(1, leUysHJ1);
			Ih74Edi6.setString(2, IrvXU3mJ.substring(0, leUysHJ1));
			GWv8THyA += Ih74Edi6.executeUpdate();
		}
		assertEquals(GWv8THyA, PqIEf3Xa);
		con.rollback();
		ResultSet hNOM4XMY = GIj1T4h1.executeQuery("select s, i from #t0010");
		assertNotNull(hNOM4XMY);
		GWv8THyA = 0;
		while (hNOM4XMY.next()) {
			GWv8THyA++;
			assertEquals(hNOM4XMY.getString(1).trim().length(), hNOM4XMY.getInt(2));
		}
		assertEquals(GWv8THyA, 0);
		PqIEf3Xa = 6;
		for (int B6Lxom19 = 1; B6Lxom19 <= 2; B6Lxom19++) {
			GWv8THyA = 0;
			for (int UW7TRnzQ = 1; UW7TRnzQ <= PqIEf3Xa; UW7TRnzQ++) {
				Ih74Edi6.setInt(1, UW7TRnzQ + ((B6Lxom19 - 1) * PqIEf3Xa));
				Ih74Edi6.setString(2, IrvXU3mJ.substring(0, UW7TRnzQ));
				GWv8THyA += Ih74Edi6.executeUpdate();
			}
			assertEquals(GWv8THyA, PqIEf3Xa);
			con.commit();
		}
		hNOM4XMY = GIj1T4h1.executeQuery("select s, i from #t0010");
		GWv8THyA = 0;
		while (hNOM4XMY.next()) {
			GWv8THyA++;
			int K8HpAO7x = hNOM4XMY.getInt(2);
			if (K8HpAO7x > PqIEf3Xa) {
				K8HpAO7x -= PqIEf3Xa;
			}
			assertEquals(hNOM4XMY.getString(1).trim().length(), K8HpAO7x);
		}
		assertEquals(GWv8THyA, (2 * PqIEf3Xa));
		GIj1T4h1.close();
		Ih74Edi6.close();
		con.setAutoCommit(true);
	}

}