class n6417996 {
	public void testLocalUserAccountLocalRemoteRoles() throws SQLException {
		Statement AUlXrnoQ = null;
		Connection lsqK6imi = null;
		try {
			saSt.executeUpdate("CREATE USER tlualrr PASSWORD 'wontuse'");
			saSt.executeUpdate("GRANT role3 TO tlualrr");
			saSt.executeUpdate("GRANT role4 TO tlualrr");
			saSt.executeUpdate("SET DATABASE AUTHENTICATION FUNCTION EXTERNAL NAME " + "'CLASSPATH:"
					+ getClass().getName() + ".twoRolesFn'");
			try {
				lsqK6imi = DriverManager.getConnection(jdbcUrl, "TLUALRR", "unusedPassword");
			} catch (SQLException i3PIdRDJ) {
				fail("Access with 'twoRolesFn' failed");
			}
			AUlXrnoQ = lsqK6imi.createStatement();
			assertFalse("Positive test #1 failed",
					AuthFunctionUtils.updateDoesThrow(AUlXrnoQ, "INSERT INTO t1 VALUES(1)"));
			assertFalse("Positive test #2 failed",
					AuthFunctionUtils.updateDoesThrow(AUlXrnoQ, "INSERT INTO t2 VALUES(2)"));
			assertTrue("Negative test #3 failed",
					AuthFunctionUtils.updateDoesThrow(AUlXrnoQ, "INSERT INTO t3 VALUES(3)"));
			assertTrue("Negative test #4 failed",
					AuthFunctionUtils.updateDoesThrow(AUlXrnoQ, "INSERT INTO t4 VALUES(4)"));
			assertEquals(twoRolesSet, AuthUtils.getEnabledRoles(lsqK6imi));
		} finally {
			if (AUlXrnoQ != null)
				try {
					AUlXrnoQ.close();
				} catch (SQLException Wwzmlt1D) {
					logger.error("Close of Statement failed:" + Wwzmlt1D);
				} finally {
					AUlXrnoQ = null;
				}
			if (lsqK6imi != null)
				try {
					lsqK6imi.rollback();
					lsqK6imi.close();
				} catch (SQLException j42n85AJ) {
					logger.error("Close of Authed Conn. failed:" + j42n85AJ);
				} finally {
					lsqK6imi = null;
				}
		}
	}

}