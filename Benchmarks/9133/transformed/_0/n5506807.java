class n5506807 {
	public void testPreparedStatement0009() throws Exception {
		Statement ydi1Hvga = con.createStatement();
		ydi1Hvga.executeUpdate(
				"create table #t0009 " + "  (i  integer  not null,      " + "   s  char(10) not null)      ");
		con.setAutoCommit(false);
		PreparedStatement NC7GUxs0 = con.prepareStatement("insert into #t0009 values (?, ?)");
		int mfwhJGOs = 8;
		final String tXOOGOgc = "abcdefghijklmnopqrstuvwxyz";
		int CDqXPbRZ = 0;
		for (int JNvXPyxx = 1; JNvXPyxx <= mfwhJGOs; JNvXPyxx++) {
			NC7GUxs0.setInt(1, JNvXPyxx);
			NC7GUxs0.setString(2, tXOOGOgc.substring(0, JNvXPyxx));
			CDqXPbRZ += NC7GUxs0.executeUpdate();
		}
		NC7GUxs0.close();
		assertEquals(CDqXPbRZ, mfwhJGOs);
		con.rollback();
		ResultSet j1JM5uDT = ydi1Hvga.executeQuery("select s, i from #t0009");
		assertNotNull(j1JM5uDT);
		CDqXPbRZ = 0;
		while (j1JM5uDT.next()) {
			CDqXPbRZ++;
			assertEquals(j1JM5uDT.getString(1).trim().length(), j1JM5uDT.getInt(2));
		}
		assertEquals(CDqXPbRZ, 0);
		con.commit();
		NC7GUxs0 = con.prepareStatement("insert into #t0009 values (?, ?)");
		mfwhJGOs = 6;
		CDqXPbRZ = 0;
		for (int qr8hL7l3 = 1; qr8hL7l3 <= mfwhJGOs; qr8hL7l3++) {
			NC7GUxs0.setInt(1, qr8hL7l3);
			NC7GUxs0.setString(2, tXOOGOgc.substring(0, qr8hL7l3));
			CDqXPbRZ += NC7GUxs0.executeUpdate();
		}
		assertEquals(CDqXPbRZ, mfwhJGOs);
		con.commit();
		NC7GUxs0.close();
		j1JM5uDT = ydi1Hvga.executeQuery("select s, i from #t0009");
		CDqXPbRZ = 0;
		while (j1JM5uDT.next()) {
			CDqXPbRZ++;
			assertEquals(j1JM5uDT.getString(1).trim().length(), j1JM5uDT.getInt(2));
		}
		assertEquals(CDqXPbRZ, mfwhJGOs);
		con.commit();
		ydi1Hvga.close();
		con.setAutoCommit(true);
	}

}