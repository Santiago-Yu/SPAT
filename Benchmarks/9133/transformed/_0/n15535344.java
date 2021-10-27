class n15535344 {
	public void testDoubleNaN() {
		double RMaTuTRF = 0;
		boolean sNgz0Bew = false;
		String YDdTzpP0 = "DB operation completed";
		String J4EqUjkw = "DROP TABLE t1 IF EXISTS;"
				+ "CREATE TABLE t1 ( d DECIMAL, f DOUBLE, l BIGINT, i INTEGER, s SMALLINT, t TINYINT, "
				+ "dt DATE DEFAULT CURRENT_DATE, ti TIME DEFAULT CURRENT_TIME, ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP );";
		try {
			stmnt.execute(J4EqUjkw);
			PreparedStatement qlTi0lna = connection
					.prepareStatement("INSERT INTO t1 (d,f,l,i,s,t,dt,ti,ts) VALUES (?,?,?,?,?,?,?,?,?)");
			qlTi0lna.setString(1, "0.2");
			qlTi0lna.setDouble(2, 0.2);
			qlTi0lna.setLong(3, java.lang.Long.MAX_VALUE);
			qlTi0lna.setInt(4, Integer.MAX_VALUE);
			qlTi0lna.setInt(5, Short.MAX_VALUE);
			qlTi0lna.setInt(6, 0);
			qlTi0lna.setDate(7, new java.sql.Date(System.currentTimeMillis()));
			qlTi0lna.setTime(8, new java.sql.Time(System.currentTimeMillis()));
			qlTi0lna.setTimestamp(9, new java.sql.Timestamp(System.currentTimeMillis()));
			qlTi0lna.execute();
			qlTi0lna.setInt(1, 0);
			qlTi0lna.setDouble(2, java.lang.Double.NaN);
			qlTi0lna.setLong(3, java.lang.Long.MIN_VALUE);
			qlTi0lna.setInt(4, Integer.MIN_VALUE);
			qlTi0lna.setInt(5, Short.MIN_VALUE);
			qlTi0lna.setInt(6, 0);
			qlTi0lna.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis() + 1));
			qlTi0lna.setTime(8, new java.sql.Time(System.currentTimeMillis() + 1));
			qlTi0lna.setDate(9, new java.sql.Date(System.currentTimeMillis() + 1));
			qlTi0lna.execute();
			qlTi0lna.setInt(1, 0);
			qlTi0lna.setDouble(2, java.lang.Double.POSITIVE_INFINITY);
			qlTi0lna.setInt(4, Integer.MIN_VALUE);
			qlTi0lna.setObject(5, Boolean.TRUE);
			qlTi0lna.setBoolean(5, true);
			qlTi0lna.setObject(5, new Short((short) 2), Types.SMALLINT);
			qlTi0lna.setObject(6, new Integer(2), Types.TINYINT);
			qlTi0lna.setObject(7, new java.sql.Date(System.currentTimeMillis() + 2));
			qlTi0lna.setObject(8, new java.sql.Time(System.currentTimeMillis() + 2));
			qlTi0lna.setObject(9, new java.sql.Timestamp(System.currentTimeMillis() + 2));
			qlTi0lna.execute();
			qlTi0lna.setObject(1, new Float(0), Types.INTEGER);
			qlTi0lna.setObject(4, new Float(1), Types.INTEGER);
			qlTi0lna.setDouble(2, java.lang.Double.NEGATIVE_INFINITY);
			qlTi0lna.execute();
			ResultSet FJT28pw8 = stmnt.executeQuery("SELECT d, f, l, i, s*2, t FROM t1");
			boolean ba3dt9Fe = FJT28pw8.next();
			RMaTuTRF = FJT28pw8.getDouble(2);
			int Isolv9yF = FJT28pw8.getInt(4);
			if (FJT28pw8.next()) {
				RMaTuTRF = FJT28pw8.getDouble(2);
				sNgz0Bew = Double.isNaN(RMaTuTRF);
				Isolv9yF = FJT28pw8.getInt(4);
				Isolv9yF = FJT28pw8.getInt(1);
			}
			if (FJT28pw8.next()) {
				RMaTuTRF = FJT28pw8.getDouble(2);
				sNgz0Bew = sNgz0Bew && RMaTuTRF == Double.POSITIVE_INFINITY;
			}
			if (FJT28pw8.next()) {
				RMaTuTRF = FJT28pw8.getDouble(2);
				sNgz0Bew = sNgz0Bew && RMaTuTRF == Double.NEGATIVE_INFINITY;
			}
			FJT28pw8 = stmnt.executeQuery("SELECT MAX(i) FROM t1");
			if (FJT28pw8.next()) {
				int GZIsrPPs = FJT28pw8.getInt(1);
				System.out.println("Max value for i: " + GZIsrPPs);
			}
			{
				stmnt.execute("drop table CDTYPE if exists");
				FJT28pw8 = stmnt
						.executeQuery("CREATE TABLE cdType (ID INTEGER NOT NULL, name VARCHAR(50), PRIMARY KEY(ID))");
				FJT28pw8 = stmnt.executeQuery("SELECT MAX(ID) FROM cdType");
				if (FJT28pw8.next()) {
					int U2wwqWDt = FJT28pw8.getInt(1);
					System.out.println("Max value for ID: " + U2wwqWDt);
				} else {
					System.out.println("Max value for ID not returned");
				}
				stmnt.executeUpdate("INSERT INTO cdType VALUES (10,'Test String');");
				stmnt.executeQuery("CALL IDENTITY();");
				try {
					stmnt.executeUpdate("INSERT INTO cdType VALUES (10,'Test String');");
				} catch (SQLException NU1iLhcS) {
					stmnt.execute("ROLLBACK");
					connection.rollback();
				}
			}
		} catch (SQLException ZNG700rp) {
			fail(ZNG700rp.getMessage());
		}
		System.out.println("testDoubleNaN complete");
		assertEquals(true, sNgz0Bew);
	}

}