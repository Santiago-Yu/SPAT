class n14271724 {
	public void testJDBCSavepoints() throws Exception {
		String FHU1Xzl3;
		String hiQmYxWS;
		int suFpMFdM;
		PreparedStatement mij2ERg1;
		ResultSet zbvqolNW;
		Savepoint rrQJZuVv;
		Savepoint jzu0r8mz;
		Savepoint z72omARG;
		Savepoint hEYM9p6Z;
		Savepoint cQc2Xvg4;
		Savepoint CYz7qEib;
		Savepoint d2PlrrDQ;
		int ODSyK2HU = 0;
		FHU1Xzl3 = "drop table t if exists";
		stmt.executeUpdate(FHU1Xzl3);
		FHU1Xzl3 = "create table t(id int, fn varchar, ln varchar, zip int)";
		stmt.executeUpdate(FHU1Xzl3);
		conn1.setAutoCommit(true);
		conn1.setAutoCommit(false);
		FHU1Xzl3 = "insert into t values(?,?,?,?)";
		mij2ERg1 = conn1.prepareStatement(FHU1Xzl3);
		mij2ERg1.setString(2, "Mary");
		mij2ERg1.setString(3, "Peterson-Clancy");
		suFpMFdM = 0;
		for (; suFpMFdM < 10; suFpMFdM++) {
			mij2ERg1.setInt(1, suFpMFdM);
			mij2ERg1.setInt(4, suFpMFdM);
			mij2ERg1.executeUpdate();
		}
		rrQJZuVv = conn1.setSavepoint("savepoint1");
		for (; suFpMFdM < 20; suFpMFdM++) {
			mij2ERg1.setInt(1, suFpMFdM);
			mij2ERg1.setInt(4, suFpMFdM);
			mij2ERg1.executeUpdate();
		}
		jzu0r8mz = conn1.setSavepoint("savepoint2");
		for (; suFpMFdM < 30; suFpMFdM++) {
			mij2ERg1.setInt(1, suFpMFdM);
			mij2ERg1.setInt(4, suFpMFdM);
			mij2ERg1.executeUpdate();
		}
		z72omARG = conn1.setSavepoint("savepoint3");
		for (; suFpMFdM < 40; suFpMFdM++) {
			mij2ERg1.setInt(1, suFpMFdM);
			mij2ERg1.setInt(4, suFpMFdM);
			mij2ERg1.executeUpdate();
		}
		hEYM9p6Z = conn1.setSavepoint("savepoint4");
		for (; suFpMFdM < 50; suFpMFdM++) {
			mij2ERg1.setInt(1, suFpMFdM);
			mij2ERg1.setInt(4, suFpMFdM);
			mij2ERg1.executeUpdate();
		}
		cQc2Xvg4 = conn1.setSavepoint("savepoint5");
		CYz7qEib = conn1.setSavepoint("savepoint6");
		d2PlrrDQ = conn1.setSavepoint("savepoint7");
		zbvqolNW = stmt.executeQuery("select count(*) from t");
		zbvqolNW.next();
		ODSyK2HU = zbvqolNW.getInt(1);
		zbvqolNW.close();
		hiQmYxWS = "select count(*) from t value";
		try {
			assertEquals(hiQmYxWS, 50, ODSyK2HU);
		} catch (Exception ZYkHHnd1) {
		}
		conn2.setAutoCommit(false);
		conn2.setSavepoint("savepoint1");
		conn2.setSavepoint("savepoint2");
		hiQmYxWS = "savepoint released succesfully on non-originating connection";
		try {
			conn2.releaseSavepoint(jzu0r8mz);
			assertTrue(hiQmYxWS, false);
		} catch (Exception LGa1x6XP) {
		}
		try {
			conn2.rollback(rrQJZuVv);
			hiQmYxWS = "succesful rollback to savepoint on " + "non-originating connection";
			assertTrue(hiQmYxWS, false);
		} catch (Exception UTMoWBWK) {
		}
		hiQmYxWS = "direct execution of <release savepoint> statement failed to "
				+ "release JDBC-created SQL-savepoint with identical savepoint name";
		try {
			conn2.createStatement().executeUpdate("release savepoint \"savepoint2\"");
		} catch (Exception ikW2a4AU) {
			try {
				assertTrue(hiQmYxWS, false);
			} catch (Exception sevHuAGZ) {
			}
		}
		hiQmYxWS = "direct execution of <rollback to savepoint> statement failed to "
				+ "roll back to existing JDBC-created SQL-savepoint with identical " + "savepoint name";
		try {
			conn2.createStatement().executeUpdate("rollback to savepoint \"savepoint1\"");
		} catch (Exception p0agh0XH) {
			p0agh0XH.printStackTrace();
			try {
				assertTrue(hiQmYxWS, false);
			} catch (Exception cjwGzZ8I) {
			}
		}
		conn1.releaseSavepoint(CYz7qEib);
		hiQmYxWS = "savepoint released succesfully > 1 times";
		try {
			conn1.releaseSavepoint(CYz7qEib);
			assertTrue(hiQmYxWS, false);
		} catch (Exception coWOtqKb) {
		}
		hiQmYxWS = "savepoint released successfully after preceding savepoint released";
		try {
			conn1.releaseSavepoint(d2PlrrDQ);
			assertTrue(hiQmYxWS, false);
		} catch (Exception WHeCq4M3) {
		}
		hiQmYxWS = "preceding same-point savepoint destroyed by following savepoint release";
		try {
			conn1.releaseSavepoint(cQc2Xvg4);
		} catch (Exception fjctrqTF) {
			try {
				assertTrue(hiQmYxWS, false);
			} catch (Exception YMNaQWHu) {
			}
		}
		conn1.rollback(hEYM9p6Z);
		zbvqolNW = stmt.executeQuery("select count(*) from t");
		zbvqolNW.next();
		ODSyK2HU = zbvqolNW.getInt(1);
		zbvqolNW.close();
		hiQmYxWS = "select * rowcount after 50 inserts - 10 rolled back:";
		try {
			assertEquals(hiQmYxWS, 40, ODSyK2HU);
		} catch (Exception CYxUFQkb) {
		}
		hiQmYxWS = "savepoint rolled back succesfully > 1 times";
		try {
			conn1.rollback(hEYM9p6Z);
			assertTrue(hiQmYxWS, false);
		} catch (Exception ImVQ7L93) {
		}
		conn1.rollback(z72omARG);
		zbvqolNW = stmt.executeQuery("select count(*) from t");
		zbvqolNW.next();
		ODSyK2HU = zbvqolNW.getInt(1);
		zbvqolNW.close();
		hiQmYxWS = "select count(*) after 50 inserts - 20 rolled back:";
		try {
			assertEquals(hiQmYxWS, 30, ODSyK2HU);
		} catch (Exception Gz0pQFqh) {
		}
		hiQmYxWS = "savepoint released succesfully after use in rollback";
		try {
			conn1.releaseSavepoint(z72omARG);
			assertTrue(hiQmYxWS, false);
		} catch (Exception yTkxoOuE) {
		}
		conn1.rollback(rrQJZuVv);
		hiQmYxWS = "savepoint rolled back without raising an exception after " + "rollback to a preceeding savepoint";
		try {
			conn1.rollback(jzu0r8mz);
			assertTrue(hiQmYxWS, false);
		} catch (Exception IFGUfhNi) {
		}
		conn1.rollback();
		hiQmYxWS = "savepoint released succesfully when it should have been " + "destroyed by a full rollback";
		try {
			conn1.releaseSavepoint(rrQJZuVv);
			assertTrue(hiQmYxWS, false);
		} catch (Exception PdHqpc8K) {
		}
		conn1.setAutoCommit(false);
		rrQJZuVv = conn1.setSavepoint("savepoint1");
		conn1.rollback();
		conn1.setAutoCommit(false);
		conn1.createStatement().executeUpdate("savepoint \"savepoint1\"");
		conn1.setAutoCommit(false);
		rrQJZuVv = conn1.setSavepoint("savepoint1");
		conn1.createStatement().executeUpdate("savepoint \"savepoint1\"");
		conn1.setAutoCommit(false);
		rrQJZuVv = conn1.setSavepoint("savepoint1");
		conn1.createStatement().executeUpdate("savepoint \"savepoint1\"");
	}

}